package com.my.ims.service.impl;

import com.my.ims.model.InventoryVO;
import com.my.ims.service.InventoryService;
import com.my.ims.service.ProductService;
import com.my.ims.service.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    ProductService productService;

    @Autowired
    SupplierService supplierService;

    @Override
    public InventoryVO createOrUpdateInventory(InventoryVO inventoryVO) {

        inventoryVO = productService.createOrUpdateProduct(inventoryVO);
        return inventoryVO;
    }

    @Override
    public InventoryVO getAllInventory(InventoryVO inventoryVO) {
        inventoryVO = productService.getAllProduct(inventoryVO);
        return inventoryVO;
    }

    @Override
    public InventoryVO getInventoryByProductId(InventoryVO inventoryVO) {

        inventoryVO = productService.getProductById(inventoryVO);
        return inventoryVO;
    }

    @Override
    public InventoryVO deleteInventoryByProductAndSupplier(InventoryVO inventoryVO) {
        return null;
    }
}
