package com.my.ims.domain.inventory;

import com.my.ims.domain.base.BaseDomain;
import com.my.ims.util.constants.TableConstants;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = TableConstants.TB_T_INVENTORY)
public class TbTInventory extends BaseDomain {

    private static final long serialVersionUID = 8981455540079848728L;

    @Id
    @Column(name = "pk_inventoryid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkInventoryId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "category")
    private String category;

    public Long getPkInventoryId() {
        return pkInventoryId;
    }

    public void setPkInventoryId(Long pkInventoryId) {
        this.pkInventoryId = pkInventoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TbTInventory that = (TbTInventory) o;
        return Objects.equals(pkInventoryId, that.pkInventoryId)
                && Objects.equals(name, that.name)
                && Objects.equals(description, that.description)
                && Objects.equals(quantity, that.quantity)
                && Objects.equals(price, that.price)
                && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pkInventoryId, name, description, quantity, price, category);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("TbTInventory{");
        builder.append("pkInventoryId=").append(pkInventoryId);
        builder.append(", name='").append(name).append('\'');
        builder.append(", description='").append(description).append('\'');
        builder.append(", quantity=").append(quantity);
        builder.append(", price=").append(price);
        builder.append(", category='").append(category).append('\'');
        builder.append('}');
        return builder.toString();
    }
}
