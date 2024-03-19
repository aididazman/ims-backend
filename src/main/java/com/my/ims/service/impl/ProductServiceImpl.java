package com.my.ims.service.impl;

import com.my.ims.domain.inventory.TbTProduct;
import com.my.ims.domain.inventory.TbTSupplier;
import com.my.ims.model.inventory.InventoryVO;
import com.my.ims.model.inventory.ProductDTO;
import com.my.ims.model.inventory.SupplierDTO;
import com.my.ims.repository.ProductRepository;
import com.my.ims.repository.SupplierRepository;
import com.my.ims.service.ProductService;
import com.my.ims.util.constants.DbStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Transactional
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public InventoryVO createOrUpdateProduct(InventoryVO inventoryVO) {

        try {

            ProductDTO productDTO = inventoryVO.getProductDTO();
            boolean isUpdate = productDTO.getPkProductId() != null;

            if (isUpdate) {

                TbTProduct tbTProduct = productRepository.findOneByPkProductIdAndStatus(productDTO.getPkProductId(), DbStatusEnum.ACTIVE.getValue());
                if (tbTProduct != null) {

                    if (productDTO.getProductName() != null)
                        tbTProduct.setProductName(productDTO.getProductName());
                    if (productDTO.getCategory() != null)
                        tbTProduct.setCategory(productDTO.getCategory());
                    if (productDTO.getDescription() != null)
                        tbTProduct.setDescription(productDTO.getDescription());
                    if (productDTO.getQuantity() != null)
                        tbTProduct.setQuantity(productDTO.getQuantity());
                    if (productDTO.getPrice() != null)
                        tbTProduct.setPrice(productDTO.getPrice());
                    if (productDTO.getCategory() != null)
                        tbTProduct.setCategory(productDTO.getCategory());
                    if (productDTO.getSupplierListDTO() != null) {

                        for (SupplierDTO supplierDTO : productDTO.getSupplierListDTO()) {

                            TbTSupplier tbTSupplier = supplierRepository.findByPkSupplierId(supplierDTO.getPkSupplierId());

                            if (supplierDTO.getName() != null)
                                tbTSupplier.setName(supplierDTO.getName());
                            if (supplierDTO.getContactInfo() != null)
                                tbTSupplier.setContactInfo(supplierDTO.getContactInfo());

                            tbTSupplier = supplierRepository.save(tbTSupplier);
                            BeanUtils.copyProperties(tbTSupplier, supplierDTO);
                        }
                    }

                    productRepository.save(tbTProduct);
                    BeanUtils.copyProperties(tbTProduct, productDTO);
                }

            } else {

                TbTProduct tbTProduct = new TbTProduct();

                if (productDTO.getProductName() != null)
                    tbTProduct.setProductName(productDTO.getProductName());
                if (productDTO.getCategory() != null)
                    tbTProduct.setCategory(productDTO.getCategory());
                if (productDTO.getDescription() != null)
                    tbTProduct.setDescription(productDTO.getDescription());
                if (productDTO.getQuantity() != null)
                    tbTProduct.setQuantity(productDTO.getQuantity());
                if (productDTO.getPrice() != null)
                    tbTProduct.setPrice(productDTO.getPrice());
                if (productDTO.getCategory() != null)
                    tbTProduct.setCategory(productDTO.getCategory());

                if (productDTO.getSupplierListDTO() != null) {
                    for (SupplierDTO supplierDTO : productDTO.getSupplierListDTO()) {

                        TbTSupplier tbTSupplier = null;
                        //check for existing id
                        if (supplierDTO.getPkSupplierId() != null) {
                            tbTSupplier = supplierRepository.findByPkSupplierId(supplierDTO.getPkSupplierId());
                            BeanUtils.copyProperties(tbTSupplier, supplierDTO);
                        } else {
                            tbTSupplier = new TbTSupplier();
                            if (supplierDTO.getName() != null)
                                tbTSupplier.setName(supplierDTO.getName());
                            if (supplierDTO.getContactInfo() != null)
                                tbTSupplier.setContactInfo(supplierDTO.getContactInfo());

                            tbTSupplier.setStatus(DbStatusEnum.ACTIVE.getValue());
                            tbTSupplier = supplierRepository.save(tbTSupplier);
                            supplierDTO.setPkSupplierId(tbTSupplier.getPkSupplierId());
                        }

                        tbTProduct.addSupplier(tbTSupplier);
                    }
                }

                tbTProduct.setStatus(DbStatusEnum.ACTIVE.getValue());
                tbTProduct = productRepository.save(tbTProduct);
                productDTO.setPkProductId(tbTProduct.getPkProductId());
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            inventoryVO.setStatus(false);
        }

        return inventoryVO;
    }

    @Override
    public InventoryVO getAllProduct(InventoryVO inventoryVO) {

        List<TbTProduct> tbTProductList = productRepository.findAllByStatus(DbStatusEnum.ACTIVE.getValue());
        List<ProductDTO> productListDTO = new ArrayList<>();

        tbTProductList.forEach(tbTProduct -> {

            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(tbTProduct, productDTO);
            List<SupplierDTO> supplierListDTO = new ArrayList<>();

            tbTProduct.getTbTSupplierList().forEach(tbTSupplier -> {
                SupplierDTO supplierDTO = new SupplierDTO();
                BeanUtils.copyProperties(tbTSupplier, supplierDTO);
                supplierListDTO.add(supplierDTO);
            });

            productDTO.setSupplierListDTO(supplierListDTO);
            productListDTO.add(productDTO);
        });

        inventoryVO.setProductListDTO(productListDTO);
        return inventoryVO;
    }

    @Override
    public InventoryVO getAllProductPaginated(InventoryVO inventoryVO) {

        Page<TbTProduct> tbTProductPage = productRepository.findAllByStatus(DbStatusEnum.ACTIVE.getValue(),
                inventoryVO.getProductPageable());
        List<TbTProduct> tbTProductList = tbTProductPage.getContent();
        List<ProductDTO> productListDTO = new ArrayList<>();


        tbTProductList.forEach(tbTProduct -> {

            ProductDTO productDTO = new ProductDTO();
            List<SupplierDTO> supplierListDTO = new ArrayList<>();

            tbTProduct.getTbTSupplierList().forEach(tbTSupplier -> {
                SupplierDTO supplierDTO = new SupplierDTO();
                BeanUtils.copyProperties(tbTSupplier, supplierDTO);
                supplierListDTO.add(supplierDTO);
            });

            productDTO.setSupplierListDTO(supplierListDTO);
            BeanUtils.copyProperties(tbTProduct, productDTO);

            productListDTO.add(productDTO);
        });

        inventoryVO.setProductListDTO(productListDTO);

        return inventoryVO;
    }

    @Override
    public InventoryVO getProductById(InventoryVO inventoryVO) {

        TbTProduct tbTProduct = productRepository.findByPkProductIdAndStatus(inventoryVO.getPkProductId(), DbStatusEnum.ACTIVE.getValue());

        if (tbTProduct !=  null) {

            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(tbTProduct, productDTO);

            List<SupplierDTO> supplierListDTO = new ArrayList<>();

            tbTProduct.getTbTSupplierList().forEach(tbTSupplier -> {
                SupplierDTO supplierDTO = new SupplierDTO();
                BeanUtils.copyProperties(tbTSupplier, supplierDTO);
                supplierDTO.setName(tbTSupplier.getName());
                supplierListDTO.add(supplierDTO);
            });

            productDTO.setSupplierListDTO(supplierListDTO);
            inventoryVO.setProductDTO(productDTO);
        }

        return inventoryVO;
    }

    @Override
    public InventoryVO deleteProductByIds(InventoryVO inventoryVO) {

        List<String> tbTProductIds = inventoryVO.getPkProductList();

        if (!tbTProductIds.isEmpty()) {
            productRepository.deleteByPkProductIds(DbStatusEnum.DELETED.getValue(), tbTProductIds);
        }

        return inventoryVO;
    }
}
