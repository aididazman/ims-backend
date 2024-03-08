package com.my.ims.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class InventoryVO implements Serializable {

    private static final long serialVersionUID = 4744240818056752948L;

    private ProductDTO productDTO;
    private SupplierDTO supplierDTO;

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public SupplierDTO getSupplierDTO() {
        return supplierDTO;
    }

    public void setSupplierDTO(SupplierDTO supplierDTO) {
        this.supplierDTO = supplierDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryVO that = (InventoryVO) o;
        return Objects.equals(productDTO, that.productDTO)
                && Objects.equals(supplierDTO, that.supplierDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productDTO, supplierDTO);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("InventoryVO{");
        builder.append("productDTO=").append(productDTO);
        builder.append(", supplierDTO=").append(supplierDTO);
        builder.append('}');
        return builder.toString();
    }
}
