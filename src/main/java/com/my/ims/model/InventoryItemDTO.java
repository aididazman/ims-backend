package com.my.ims.model;

import java.io.Serializable;
import java.util.Objects;

public class InventoryItemDTO implements Serializable {

    private static final long serialVersionUID = -8602516259813284129L;

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
        InventoryItemDTO that = (InventoryItemDTO) o;
        return Objects.equals(productDTO, that.productDTO) && Objects.equals(supplierDTO, that.supplierDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productDTO, supplierDTO);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InventoryItemDTO{");
        sb.append("productDTO=").append(productDTO);
        sb.append(", supplierDTO=").append(supplierDTO);
        sb.append('}');
        return sb.toString();
    }
}
