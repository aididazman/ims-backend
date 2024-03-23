package com.my.ims.inventory.supplier;

import com.my.ims.inventory.InventoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public InventoryVO createOrUpdateSupplier(InventoryVO inventoryVO) {
        return null;
    }

    @Override
    public InventoryVO getAllSupplier(InventoryVO inventoryVO) {
        return null;
    }

    @Override
    public InventoryVO getSupplierById(InventoryVO inventoryVO) {
        return null;
    }

    @Override
    public InventoryVO deleteSupplierByIds(InventoryVO inventoryVO) {
        return null;
    }

    @Override
    public InventoryVO getSupplierByProductId(InventoryVO inventoryVO) {

        return inventoryVO;
    }
}
