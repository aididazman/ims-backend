package com.my.ims.inventory.supplier;

import com.my.ims.inventory.supplier.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

}
