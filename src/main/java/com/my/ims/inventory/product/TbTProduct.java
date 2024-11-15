package com.my.ims.inventory.product;

import com.my.ims.base.domain.BaseDomain;
import com.my.ims.inventory.supplier.TbTSupplier;
import com.my.ims.util.constants.TableConstants;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TableConstants.TB_T_PRODUCT)
public class TbTProduct extends BaseDomain {

    @Serial
    private static final long serialVersionUID = 8981455540079848728L;

    @Id
    @Column(name = "pk_productid")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String pkProductId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "category")
    private String category;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = TableConstants.TB_M_PRODUCTSUPPLY,
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "supply_id")
    )
    private Set<TbTSupplier> tbTSupplierList = new HashSet<>();

    public TbTProduct addSupplier(TbTSupplier tbTSupplier) {
        this.tbTSupplierList.add(tbTSupplier);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TbTProduct that = (TbTProduct) o;
        return Objects.equals(pkProductId, that.pkProductId)
                && Objects.equals(productName, that.productName)
                && Objects.equals(description, that.description)
                && Objects.equals(quantity, that.quantity)
                && Objects.equals(price, that.price)
                && Objects.equals(category, that.category)
                && Objects.equals(tbTSupplierList, that.tbTSupplierList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pkProductId, productName, description, quantity,
                price, category, tbTSupplierList);
    }
}
