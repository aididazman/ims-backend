package com.my.ims.inventory;

import com.my.ims.inventory.product.ProductDTO;
import com.my.ims.form.CommonCompositeDeleteCommand;
import com.my.ims.inventory.product.ProductService;
import com.my.ims.inventory.supplier.SupplierDTO;
import com.my.ims.inventory.supplier.SupplierService;
import com.my.ims.util.constants.MessageConstants;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    ProductService productService;

    @Autowired
    SupplierService supplierService;

    @Operation( summary = "add inventory", tags = { "inventory-management" })
    @PostMapping("/add-inventory")
    public ResponseEntity<ProductDTO> createInventory(@RequestBody ProductDTO productDTO) {

        log.info("REST request to create inventory: {}", productDTO);

        InventoryVO inventoryVO = new InventoryVO();
        inventoryVO.setProductDTO(productDTO);
        inventoryVO = productService.createOrUpdateProduct(inventoryVO);

        return new ResponseEntity<>(inventoryVO.getProductDTO(), HttpStatus.OK);
    }

    @Operation( summary = "update inventory", tags = { "inventory-management" })
    @PostMapping("/update-inventory")
    public ResponseEntity<ProductDTO> updateInventory(@RequestBody ProductDTO productDTO) {

        log.info("REST request to update inventory: {}", productDTO);

        InventoryVO inventoryVO = new InventoryVO();
        inventoryVO.setProductDTO(productDTO);
        inventoryVO = productService.createOrUpdateProduct(inventoryVO);

        return new ResponseEntity<>(inventoryVO.getProductDTO(), HttpStatus.OK);
    }

    @Operation( summary = "get all inventory paginated", tags = { "inventory-management" })
    @GetMapping("/inventory")
    public ResponseEntity<List<ProductDTO>> getAllInventoryPaginated(Pageable productPaginated) {

        log.info("REST request to get all inventory");

        InventoryVO inventoryVO = new InventoryVO();
        inventoryVO.setProductPageable(productPaginated);

        inventoryVO = productService.getAllProductPaginated(inventoryVO);

        return new ResponseEntity<>(inventoryVO.getProductListDTO(), HttpStatus.OK);
    }

    @Operation( summary = "get inventory by product id", tags = { "inventory-management" })
    @GetMapping("/inventory/product/{pkProductId}")
    public ResponseEntity<ProductDTO> getInventoryByProductId(@PathVariable String pkProductId) {

        log.info("REST request to get inventory by product id: {}", pkProductId);

        InventoryVO inventoryVO = new InventoryVO();
        inventoryVO.setPkProductId(pkProductId);
        inventoryVO = productService.getProductById(inventoryVO);

        return new ResponseEntity<>(inventoryVO.getProductDTO(), HttpStatus.OK);
    }

    @Operation( summary = "get inventory by supplier id", tags = { "inventory-management" })
    @GetMapping("/inventory/supplier/{pkSupplierId}")
    public ResponseEntity<SupplierDTO> getInventoryBySupplierId(@PathVariable String pkSupplierId) {

        log.info("REST request to get inventory by supplier id: {}", pkSupplierId);

        InventoryVO inventoryVO = new InventoryVO();
        inventoryVO.setPkSupplierId(pkSupplierId);
        inventoryVO = supplierService.getSupplierById(inventoryVO);

        return new ResponseEntity<>(inventoryVO.getSupplierDTO(), HttpStatus.OK);
    }

    @Operation( summary = "delete inventory by product", tags = { "inventory-management" })
    @PostMapping("/delete-inventory")
    public ResponseEntity<String> deleteByProductIds(@RequestBody CommonCompositeDeleteCommand commonCompositeDeleteCommand) {

        InventoryVO inventoryVO = new InventoryVO();
        inventoryVO.setPkProductIds(Arrays.asList(commonCompositeDeleteCommand.getIds()));

        log.info("REST request to delete product by ids: {}", inventoryVO.getPkProductIds());

        inventoryVO = productService.deleteProductByIds(inventoryVO);

        return new ResponseEntity<String>(MessageConstants.MESSAGE_SUCCESS_PRODUCT_DELETED, HttpStatus.OK);
    }


}
