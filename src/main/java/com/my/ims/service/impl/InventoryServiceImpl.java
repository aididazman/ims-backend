package com.my.ims.service.impl;

import com.my.ims.model.InventoryVO;
import com.my.ims.service.InventoryService;
import com.my.ims.service.ProductService;
import com.my.ims.service.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    ProductService productService;

    @Autowired
    SupplierService supplierService;

    @Override
    public InventoryVO createOrUpdateInventory(InventoryVO inventoryVO) {
        return null;
    }

    @Override
    public InventoryVO getAllInventory(InventoryVO inventoryVO) {
        return null;
    }

    @Override
    public InventoryVO getInventoryByProductId(InventoryVO inventoryVO) {
        return null;
    }

    @Override
    public InventoryVO deleteInventoryByProductAndSupplier(InventoryVO inventoryVO) {
        return null;
    }
}
