package com.my.ims.inventory;

import com.my.ims.inventory.product.ProductWithSupplierDTO;
import com.my.ims.inventory.product.TbTProduct;
import com.my.ims.inventory.product.ProductDTO;
import com.my.ims.inventory.supplier.SupplierDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4744240818056752948L;

    private String pkProductId;
    private List<String> pkProductIds;
    private ProductDTO productDTO;
    private ProductWithSupplierDTO productWithSupplierDTO;
    private List<ProductDTO> productListDTO;
    private List<ProductWithSupplierDTO> productWithSupplierListDTO;
    private Page<TbTProduct> productPaginated;
    private Pageable productPageable;

    private String pkSupplierId;
    private List<String> pkSupplierIds;
    private SupplierDTO supplierDTO;
    private List<SupplierDTO> supplierListDTO;

    private Boolean status = true;
}
