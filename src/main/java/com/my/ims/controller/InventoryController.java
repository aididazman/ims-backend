package com.my.ims.controller;

import com.my.ims.model.InventoryItemDTO;
import com.my.ims.model.InventoryVO;
import com.my.ims.model.ProductDTO;
import com.my.ims.model.form.CommonCompositeDeleteDO;
import com.my.ims.service.InventoryService;
import com.my.ims.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    InventoryService inventoryService;

    @Autowired
    ProductService productService;

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

    //TODO: do pagination
    @Operation( summary = "get all inventory", tags = { "inventory-management" })
    @GetMapping("/inventory")
    public ResponseEntity<List<ProductDTO>> getAllInventory() {

        log.info("REST request to get all inventory");

        InventoryVO inventoryVO = new InventoryVO();
        inventoryVO = inventoryService.getAllInventory(inventoryVO);

        return new ResponseEntity<>(inventoryVO.getProductListDTO(), HttpStatus.OK);
    }

    @Operation( summary = "get inventory by product id", tags = { "inventory-management" })
    @GetMapping("/inventory/{pkProductId}")
    public ResponseEntity<ProductDTO> getInventoryByProductId(@PathVariable String pkProductId) {

        log.info("REST request to get inventory by product id: {}", pkProductId);

        InventoryVO inventoryVO = new InventoryVO();
        inventoryVO.setPkProductId(pkProductId);
        inventoryVO = inventoryService.getInventoryByProductId(inventoryVO);

        return new ResponseEntity<>(inventoryVO.getProductDTO(), HttpStatus.OK);
    }

    //TODO: refactor
    @Operation( summary = "delete inventory by product and supplier", tags = { "inventory-management" })
    @PostMapping("/delete-inventory")
    public ResponseEntity<ProductDTO> deleteByProductAndSupplier(@RequestBody CommonCompositeDeleteDO commonCompositeDeleteDO) {

        InventoryVO inventoryVO = new InventoryVO();
        inventoryVO.setPkProductList(Arrays.asList(commonCompositeDeleteDO.getIds()));

        log.info("REST request to delete product by ids: {}", inventoryVO.getPkProductList());

        inventoryVO = inventoryService.deleteInventoryByProductAndSupplier(inventoryVO);

        return new ResponseEntity<>(inventoryVO.getProductDTO(), HttpStatus.OK);
    }


}
