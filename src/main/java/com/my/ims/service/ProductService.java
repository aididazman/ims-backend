package com.my.ims.service;

import com.my.ims.model.InventoryVO;

public interface ProductService {

    InventoryVO createOrUpdateProduct(InventoryVO inventoryVO);
    InventoryVO getAllProduct(InventoryVO inventoryVO);
    InventoryVO getProductById(InventoryVO inventoryVO);
    InventoryVO deleteProductByIds(InventoryVO inventoryVO);

}
