package com.my.ims.inventory.product;

import com.my.ims.inventory.InventoryVO;

public interface ProductService {

    InventoryVO createOrUpdateProduct(InventoryVO inventoryVO);
    InventoryVO getAllProduct(InventoryVO inventoryVO);
    InventoryVO getAllProductPaginated(InventoryVO inventoryVO);
    InventoryVO getProductById(InventoryVO inventoryVO);
    InventoryVO deleteProductByIds(InventoryVO inventoryVO);
    InventoryVO getAllProductBySupplierIds(InventoryVO inventoryVO);

}
