package com.my.ims.inventory.product;

import com.my.ims.form.CommonDeleteCommand;
import com.my.ims.inventory.InventoryVO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation( summary = "add product", tags = { "product-management" })
    @PostMapping("/product")
    public ResponseEntity<List<ProductDTO>> createProduct(@RequestBody List<ProductDTO> productListDTO) {

        log.info("REST request to create: {}", productListDTO);
        productListDTO = productService.create(productListDTO);
        return new ResponseEntity<>(productListDTO, HttpStatus.OK);
    }

    @Operation( summary = "update product", tags = { "product-management" })
    @PutMapping("/product")
    public ResponseEntity<List<ProductDTO>> updateProduct(@RequestBody List<ProductDTO> productListDTO) {

        log.info("REST request to update: {}", productListDTO);
        productListDTO = productService.update(productListDTO);
        return new ResponseEntity<>(productListDTO, HttpStatus.OK);
    }

    @Operation( summary = "get product by id", tags = { "product-management" })
    @GetMapping("/product/{pkProductId}")
    public ResponseEntity<ProductWithSupplierDTO> getProductById(@PathVariable String pkProductId) {

        log.info("REST request to get product by id: {}", pkProductId);

        InventoryVO inventoryVO = new InventoryVO();
        inventoryVO.setPkProductId(pkProductId);
        inventoryVO = productService.getProductById(inventoryVO);

        return new ResponseEntity<>(inventoryVO.getProductWithSupplierDTO(), HttpStatus.OK);
    }

    @Operation( summary = "delete product by ids", tags = { "product-management" })
    @PostMapping("/product/delete")
    public ResponseEntity<ProductDTO> deleteProductById(@RequestBody CommonDeleteCommand commonDeleteCommand) {

        InventoryVO inventoryVO = new InventoryVO();
        inventoryVO.setPkProductIds(Arrays.asList(commonDeleteCommand.getIds()));

        log.info("REST request to delete product by ids: {}", inventoryVO.getPkProductIds());

        inventoryVO = productService.deleteProductByIds(inventoryVO);

        return new ResponseEntity<>(inventoryVO.getProductDTO(), HttpStatus.OK);
    }


}
