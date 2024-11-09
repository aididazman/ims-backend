package com.my.ims.inventory.product;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -2397678789843128779L;

    private String pkProductId;
    private String productName;
    private String description;
    private Long quantity;
    private BigDecimal price;
    private String category;

}
