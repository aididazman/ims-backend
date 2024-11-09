package com.my.ims.inventory.product;

import com.my.ims.inventory.supplier.SupplierDTO;
import lombok.*;

import java.io.Serial;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductWithSupplierDTO extends ProductDTO {

    @Serial
    private static final long serialVersionUID = -7201166572484809211L;

    private List<SupplierDTO> supplierListDTO;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductWithSupplierDTO that = (ProductWithSupplierDTO) o;
        return Objects.equals(supplierListDTO, that.supplierListDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), supplierListDTO);
    }
}
