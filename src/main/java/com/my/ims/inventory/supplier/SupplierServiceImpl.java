package com.my.ims.inventory.supplier;

import com.my.ims.inventory.InventoryVO;
import com.my.ims.inventory.product.ProductDTO;
import com.my.ims.inventory.product.ProductService;
import com.my.ims.util.constants.DbStatusEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    ProductService productService;

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

        TbTSupplier tbTSupplier = supplierRepository.findByPkSupplierIdAndStatus(inventoryVO.getPkSupplierId(),
                DbStatusEnum.ACTIVE.getValue());

        if (tbTSupplier != null) {

            SupplierWithProductDTO supplierWithProductDTO = new SupplierWithProductDTO();
            BeanUtils.copyProperties(tbTSupplier, supplierWithProductDTO);

            List<ProductDTO> productListDTO;

            List<String> pkSupplierIds = new ArrayList<>();
            pkSupplierIds.add(inventoryVO.getPkSupplierId());
            inventoryVO.setPkSupplierIds(pkSupplierIds);

            inventoryVO = productService.getAllProductBySupplierIds(inventoryVO);
            productListDTO = inventoryVO.getProductListDTO();

            if (!productListDTO.isEmpty())
                supplierWithProductDTO.setProductListDTO(productListDTO);

            inventoryVO.setSupplierDTO(supplierWithProductDTO);
        }

        return inventoryVO;
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
