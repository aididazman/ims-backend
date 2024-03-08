package com.my.ims.service;

import com.my.ims.model.InventoryVO;

public interface ProductService {

    InventoryVO createProduct(InventoryVO inventoryVO);
    InventoryVO getAllProduct(InventoryVO inventoryVO);
    InventoryVO getProductById(InventoryVO inventoryVO);
    InventoryVO deleteProduct(InventoryVO inventoryVO);

}
