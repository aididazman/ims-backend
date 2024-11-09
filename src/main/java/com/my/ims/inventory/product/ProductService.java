package com.my.ims.inventory.product;

import com.my.ims.inventory.InventoryVO;

import java.util.List;

public interface ProductService {

    <T extends ProductDTO> List<T> create(List<T> productList);
    <T extends ProductDTO> List<T> update(List<T> productList);
    InventoryVO getAllProductPaginated(InventoryVO inventoryVO);
    InventoryVO getProductById(InventoryVO inventoryVO);
    InventoryVO deleteProductByIds(InventoryVO inventoryVO);
    InventoryVO getAllProductBySupplierIds(InventoryVO inventoryVO);

}
