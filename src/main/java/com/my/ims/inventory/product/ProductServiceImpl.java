package com.my.ims.inventory.product;

import com.my.ims.inventory.supplier.TbTSupplier;
import com.my.ims.inventory.InventoryVO;
import com.my.ims.inventory.supplier.SupplierDTO;
import com.my.ims.inventory.supplier.SupplierRepository;
import com.my.ims.util.constants.DbStatusEnum;
import com.my.ims.util.exceptions.domain.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Transactional
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public <T extends ProductDTO> List<T> create(List<T> productList) {

        for (T product : productList) {

            TbTProduct tbTProduct = new TbTProduct();

            if (product instanceof ProductWithSupplierDTO productWithSupplierDTO) {
                BeanUtils.copyProperties(productWithSupplierDTO, tbTProduct);
                addSupplier(tbTProduct, productWithSupplierDTO.getSupplierListDTO());
            } else {
                BeanUtils.copyProperties(product, tbTProduct);
            }

            log.info("Saving TbTProduct: {}", tbTProduct);
            tbTProduct = productRepository.save(tbTProduct);
            product.setPkProductId(tbTProduct.getPkProductId());

        }

        return productList;
    }

    private void addSupplier(TbTProduct tbTProduct, List<SupplierDTO> supplierListDTO) {

        for (SupplierDTO supplierDTO : supplierListDTO) {

            TbTSupplier tbTSupplier = null;

            if (supplierDTO.getPkSupplierId() != null) {
                log.info("Find TbTSupplier by id: {}", supplierDTO.getPkSupplierId());
                tbTSupplier = Optional.ofNullable(supplierRepository.findByPkSupplierIdAndStatus(
                                supplierDTO.getPkSupplierId(), DbStatusEnum.ACTIVE.getValue()))
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Product with supplier not exist with pkSupplierId:" + supplierDTO.getPkSupplierId()));
                BeanUtils.copyProperties(tbTSupplier, supplierDTO);
            } else {
                tbTSupplier = TbTSupplier.builder()
                        .name(supplierDTO.getName())
                        .contactInfo(supplierDTO.getContactInfo())
                        .build();

                tbTSupplier = supplierRepository.save(tbTSupplier);
                supplierDTO.setPkSupplierId(tbTSupplier.getPkSupplierId());
            }

            tbTProduct.addSupplier(tbTSupplier);
        }
    }

    @Override
    public <T extends ProductDTO> List<T> update(List<T> productList) {

        for (T product : productList) {

            if (product.getPkProductId().isEmpty())
                throw new IllegalArgumentException("pkProductId is null");

            TbTProduct tbTProduct = Optional.ofNullable(productRepository.findOneByPkProductIdAndStatus(
                    product.getPkProductId(), DbStatusEnum.ACTIVE.getValue()))
                    .orElseThrow(() -> new ResourceNotFoundException("Product not exist with pkProductId:"
                            + product.getPkProductId()));

            if (product instanceof ProductWithSupplierDTO productWithSupplierDTO) {
                BeanUtils.copyProperties(productWithSupplierDTO, tbTProduct);
                updateSupplier(productWithSupplierDTO.getSupplierListDTO(), tbTProduct);
            } else {
                BeanUtils.copyProperties(product, tbTProduct);
            }

            log.info("Updating TbTProduct: {}", tbTProduct);
            productRepository.save(tbTProduct);
            BeanUtils.copyProperties(tbTProduct, product);
        }

        return productList;
    }

    private void updateSupplier(List<SupplierDTO> supplierListDTO, TbTProduct tbTProduct) {

        Set<TbTSupplier> tbTSupplierList = new HashSet<>();

        supplierListDTO.forEach(supplierDTO -> {
            log.info("Find TbTSupplier by id: {}", supplierDTO.getPkSupplierId());
            TbTSupplier tbTSupplier = Optional.ofNullable(supplierRepository.findByPkSupplierIdAndStatus(
                    supplierDTO.getPkSupplierId(), DbStatusEnum.ACTIVE.getValue()))
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Product with supplier not exist with pkSupplierId:" + supplierDTO.getPkSupplierId()));

            tbTSupplierList.add(tbTSupplier);
            BeanUtils.copyProperties(tbTSupplier, supplierDTO);
        });

        tbTProduct.setTbTSupplierList(tbTSupplierList);
    }

    @Override
    public InventoryVO getAllProductPaginated(InventoryVO inventoryVO) {

        Page<TbTProduct> tbTProductPage = productRepository.findAllByStatus(DbStatusEnum.ACTIVE.getValue(),
                inventoryVO.getProductPageable());
        List<TbTProduct> tbTProductList = tbTProductPage.getContent();
        List<ProductWithSupplierDTO> productWithSupplierListDTO = new ArrayList<>();

        tbTProductList.forEach(tbTProduct -> {

            ProductWithSupplierDTO productWithSupplierDTO = new ProductWithSupplierDTO();
            List<SupplierDTO> supplierListDTO = new ArrayList<>();

            tbTProduct.getTbTSupplierList().forEach(tbTSupplier -> {
                SupplierDTO supplierDTO = new SupplierDTO();
                BeanUtils.copyProperties(tbTSupplier, supplierDTO);
                supplierListDTO.add(supplierDTO);
            });

            productWithSupplierDTO.setSupplierListDTO(supplierListDTO);
            BeanUtils.copyProperties(tbTProduct, productWithSupplierDTO);

            productWithSupplierListDTO.add(productWithSupplierDTO);
        });

        inventoryVO.setProductWithSupplierListDTO(productWithSupplierListDTO);

        return inventoryVO;
    }

    @Override
    public InventoryVO getProductById(InventoryVO inventoryVO) {

        TbTProduct tbTProduct = productRepository.findByPkProductIdAndStatus(inventoryVO.getPkProductId(),
                DbStatusEnum.ACTIVE.getValue());

        if (tbTProduct !=  null) {

            ProductWithSupplierDTO productWithSupplierDTO = new ProductWithSupplierDTO();
            BeanUtils.copyProperties(tbTProduct, productWithSupplierDTO);

            List<SupplierDTO> supplierListDTO = new ArrayList<>();

            tbTProduct.getTbTSupplierList().forEach(tbTSupplier -> {
                SupplierDTO supplierDTO = new SupplierDTO();
                BeanUtils.copyProperties(tbTSupplier, supplierDTO);
                supplierListDTO.add(supplierDTO);
            });

            productWithSupplierDTO.setSupplierListDTO(supplierListDTO);
            inventoryVO.setProductWithSupplierDTO(productWithSupplierDTO);
        }

        return inventoryVO;
    }


    @Override
    public InventoryVO deleteProductByIds(InventoryVO inventoryVO) {

        List<String> tbTProductIds = inventoryVO.getPkProductIds();

        if (!tbTProductIds.isEmpty()) {
            productRepository.deleteByPkProductIds(DbStatusEnum.DELETED.getValue(), tbTProductIds);
        }

        return inventoryVO;
    }

    @Override
    public InventoryVO getAllProductBySupplierIds(InventoryVO inventoryVO) {

        List<TbTProduct> tbTProductList = productRepository.findByTbTSupplierListPkSupplierIdInAndStatus(inventoryVO.getPkSupplierIds(),
                DbStatusEnum.ACTIVE.getValue());

        List<ProductDTO> productListDTO = new ArrayList<>();

        tbTProductList.forEach(tbTProduct -> {

            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(tbTProduct, productDTO);
            productListDTO.add(productDTO);
        });

        inventoryVO.setProductListDTO(productListDTO);
        return inventoryVO;
    }
}
