package com.my.ims.inventory.supplier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 3379939900194449766L;

    private String pkSupplierId;
    private String name;
    private String contactInfo;
}
