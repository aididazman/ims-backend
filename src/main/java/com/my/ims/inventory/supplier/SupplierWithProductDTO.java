package com.my.ims.inventory.supplier;

import com.my.ims.inventory.product.ProductDTO;
import lombok.*;

import java.io.Serial;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierWithProductDTO extends SupplierDTO {

    @Serial
    private static final long serialVersionUID = -5999455379711623113L;

    private List<ProductDTO> productListDTO;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SupplierWithProductDTO that = (SupplierWithProductDTO) o;
        return Objects.equals(productListDTO, that.productListDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), productListDTO);
    }
}
