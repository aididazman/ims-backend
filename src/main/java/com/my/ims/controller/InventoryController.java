package com.my.ims.controller;

import com.my.ims.model.InventoryItemDTO;
import com.my.ims.model.InventoryVO;
import com.my.ims.model.ProductDTO;
import com.my.ims.model.form.CommonCompositeDeleteDO;
import com.my.ims.service.InventoryService;
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

    @Operation( summary = "add inventory", tags = { "inventory-management" })
    @PostMapping("/add-inventory")
    public ResponseEntity<InventoryItemDTO> createInventory(@RequestBody InventoryItemDTO inventoryItemDTO) {

        log.info("REST request to create inventory: {}", inventoryItemDTO);

        InventoryVO inventoryVO = new InventoryVO();
        inventoryVO.setInventoryItemDTO(inventoryItemDTO);
        inventoryVO = inventoryService.createOrUpdateInventory(inventoryVO);

        return new ResponseEntity<>(inventoryVO.getInventoryItemDTO(), HttpStatus.OK);
    }

    @Operation( summary = "update inventory", tags = { "inventory-management" })
    @PostMapping("/update-inventory")
    public ResponseEntity<InventoryItemDTO> updateInventory(@RequestBody InventoryItemDTO inventoryItemDTO) {

        log.info("REST request to update inventory: {}", inventoryItemDTO);

        InventoryVO inventoryVO = new InventoryVO();
        inventoryVO.setInventoryItemDTO(inventoryItemDTO);
        inventoryVO = inventoryService.createOrUpdateInventory(inventoryVO);

        return new ResponseEntity<>(inventoryVO.getInventoryItemDTO(), HttpStatus.OK);
    }

    //TODO: do pagination
    @Operation( summary = "get all inventory", tags = { "inventory-management" })
    @GetMapping("/inventory")
    public ResponseEntity<List<InventoryItemDTO>> getAllInventory() {

        log.info("REST request to get all inventory");

        InventoryVO inventoryVO = new InventoryVO();
        inventoryVO = inventoryService.getAllInventory(inventoryVO);

        return new ResponseEntity<>(inventoryVO.getInventoryItemListDTO(), HttpStatus.OK);
    }

    @Operation( summary = "get inventory by product id", tags = { "inventory-management" })
    @GetMapping("/inventory/{pkProductId}")
    public ResponseEntity<InventoryItemDTO> getInventoryByProductId(@PathVariable String pkProductId) {

        log.info("REST request to get inventory by product id: {}", pkProductId);

        InventoryVO inventoryVO = new InventoryVO();
        inventoryVO.setPkProductId(pkProductId);
        inventoryVO = inventoryService.getInventoryByProductId(inventoryVO);

        return new ResponseEntity<>(inventoryVO.getInventoryItemDTO(), HttpStatus.OK);
    }

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
