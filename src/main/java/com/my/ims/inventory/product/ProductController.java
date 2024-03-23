package com.my.ims.inventory.product;

import com.my.ims.form.CommonCompositeDeleteCommand;
import com.my.ims.inventory.InventoryVO;
import com.my.ims.inventory.product.ProductDTO;
import com.my.ims.inventory.product.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @Operation( summary = "add product", tags = { "product-management" })
    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createOrUpdateProduct(@RequestBody ProductDTO productDTO) {

        log.info("REST request to create or update product: {}", productDTO);

        InventoryVO inventoryVO = new InventoryVO();
        inventoryVO.setProductDTO(productDTO);
        inventoryVO = productService.createOrUpdateProduct(inventoryVO);

        return new ResponseEntity<>(inventoryVO.getProductDTO(), HttpStatus.OK);
    }

    @Operation( summary = "get product by id", tags = { "product-management" })
    @GetMapping("/product/{pkProductId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable String pkProductId) {

        log.info("REST request to get product by id: {}", pkProductId);

        InventoryVO inventoryVO = new InventoryVO();
        inventoryVO.setPkProductId(pkProductId);
        inventoryVO = productService.getProductById(inventoryVO);

        return new ResponseEntity<>(inventoryVO.getProductDTO(), HttpStatus.OK);
    }

    @Operation( summary = "delete product by ids", tags = { "product-management" })
    @PostMapping("/product/delete")
    public ResponseEntity<ProductDTO> deleteProductById(@RequestBody CommonCompositeDeleteCommand commonCompositeDeleteCommand) {

        InventoryVO inventoryVO = new InventoryVO();
        inventoryVO.setPkProductList(Arrays.asList(commonCompositeDeleteCommand.getIds()));

        log.info("REST request to delete product by ids: {}", inventoryVO.getPkProductList());

        inventoryVO = productService.deleteProductByIds(inventoryVO);

        return new ResponseEntity<>(inventoryVO.getProductDTO(), HttpStatus.OK);
    }


}
