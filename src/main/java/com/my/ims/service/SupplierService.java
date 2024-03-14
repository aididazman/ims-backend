package com.my.ims.service;

import com.my.ims.model.inventory.InventoryVO;

public interface SupplierService {
    InventoryVO createOrUpdateSupplier(InventoryVO inventoryVO);
    InventoryVO getAllSupplier(InventoryVO inventoryVO);
    InventoryVO getSupplierById(InventoryVO inventoryVO);
    InventoryVO deleteSupplierByIds(InventoryVO inventoryVO);
    InventoryVO getSupplierByProductId(InventoryVO inventoryVO);
}
