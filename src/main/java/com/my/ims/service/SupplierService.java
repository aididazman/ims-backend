package com.my.ims.service;

import com.my.ims.model.InventoryVO;

public interface SupplierService {
    InventoryVO createSupplier(InventoryVO inventoryVO);
    InventoryVO getAllSupplier(InventoryVO inventoryVO);
    InventoryVO getSupplierById(InventoryVO inventoryVO);
    InventoryVO deleteSupplier(InventoryVO inventoryVO);
}
