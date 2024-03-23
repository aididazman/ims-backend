package com.my.ims.inventory.supplier;

import com.my.ims.inventory.InventoryVO;

public interface SupplierService {
    InventoryVO createOrUpdateSupplier(InventoryVO inventoryVO);
    InventoryVO getAllSupplier(InventoryVO inventoryVO);
    InventoryVO getSupplierById(InventoryVO inventoryVO);
    InventoryVO deleteSupplierByIds(InventoryVO inventoryVO);
    InventoryVO getSupplierByProductId(InventoryVO inventoryVO);
}
