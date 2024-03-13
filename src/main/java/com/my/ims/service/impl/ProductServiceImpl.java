package com.my.ims.service.impl;

import com.my.ims.domain.auth.TbTRole;
import com.my.ims.domain.auth.TbTUser;
import com.my.ims.domain.inventory.TbTProduct;
import com.my.ims.domain.inventory.TbTSupplier;
import com.my.ims.model.InventoryVO;
import com.my.ims.model.ProductDTO;
import com.my.ims.model.SupplierDTO;
import com.my.ims.repository.ProductRepository;
import com.my.ims.repository.RoleRepository;
import com.my.ims.repository.SupplierRepository;
import com.my.ims.repository.UserRepository;
import com.my.ims.service.ProductService;
import com.my.ims.util.ApplicationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

                TbTProduct tbTProduct = productRepository.findOneByPkProductId(productDTO.getPkProductId());
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

                            tbTProduct.setModifiedBy(1L);
                            tbTProduct.setModifiedDate(ApplicationUtil.getLocalTime());
                            tbTSupplier = supplierRepository.save(tbTSupplier);
                            BeanUtils.copyProperties(tbTSupplier, supplierDTO);
                        }
                    }

                    tbTProduct.setModifiedBy(1L);
                    tbTProduct.setModifiedDate(ApplicationUtil.getLocalTime());
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
                        TbTSupplier tbTSupplier = new TbTSupplier();
                        if (supplierDTO.getName() != null)
                            tbTSupplier.setName(supplierDTO.getName());
                        if (supplierDTO.getContactInfo() != null)
                            tbTSupplier.setContactInfo(supplierDTO.getContactInfo());

                        tbTSupplier.setStatus(true);
                        tbTSupplier.setCreatedBy(1L);
                        tbTSupplier.setCreatedDate(ApplicationUtil.getLocalTime());
                        tbTSupplier.setModifiedBy(1L);
                        tbTSupplier.setModifiedDate(ApplicationUtil.getLocalTime());
                        tbTSupplier = supplierRepository.save(tbTSupplier);
                        tbTProduct.addSupplier(tbTSupplier);
                        supplierDTO.setPkSupplierId(tbTSupplier.getPkSupplierId());
                    }
                }

                tbTProduct.setStatus(true);
                tbTProduct.setCreatedBy(1L);
                tbTProduct.setCreatedDate(ApplicationUtil.getLocalTime());
                tbTProduct.setModifiedBy(1L);
                tbTProduct.setModifiedDate(ApplicationUtil.getLocalTime());
                tbTProduct = productRepository.save(tbTProduct);
                productDTO.setPkProductId(tbTProduct.getPkProductId());
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return inventoryVO;
    }

    @Override
    public InventoryVO getAllProduct(InventoryVO inventoryVO) {
        List<TbTProduct> tbTProductList = productRepository.findAll();
        List<ProductDTO> productListDTO = new ArrayList<>();

        for (TbTProduct tbTProduct : tbTProductList) {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(tbTProduct, productDTO);
            productListDTO.add(productDTO);
        }

        inventoryVO.setProductListDTO(productListDTO);
        return inventoryVO;
    }

    @Override
    public InventoryVO getProductById(InventoryVO inventoryVO) {

        TbTProduct tbtProduct = productRepository.findByPkProductId(inventoryVO.getPkProductId());
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(tbtProduct, productDTO);

        List<SupplierDTO> supplierListDTO = new ArrayList<>();

        for (TbTSupplier tbTSupplier : tbtProduct.getTbTSupplierList()) {
            SupplierDTO supplierDTO = new SupplierDTO();
            BeanUtils.copyProperties(tbTSupplier, supplierDTO);
            supplierDTO.setName(tbTSupplier.getName());
            supplierListDTO.add(supplierDTO);
        }

        productDTO.setSupplierListDTO(supplierListDTO);
        inventoryVO.setProductDTO(productDTO);
        return inventoryVO;
    }

    @Override
    public InventoryVO deleteProductByIds(InventoryVO inventoryVO) {
        return null;
    }
}
