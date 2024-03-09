package com.my.ims.service;

import com.my.ims.model.InventoryVO;

public interface InventoryService {

    InventoryVO createOrUpdateInventory(InventoryVO inventoryVO);
    InventoryVO getAllInventory(InventoryVO inventoryVO);
    InventoryVO getInventoryByProductId(InventoryVO inventoryVO);
    InventoryVO deleteInventoryByProductAndSupplier(InventoryVO inventoryVO);

}
