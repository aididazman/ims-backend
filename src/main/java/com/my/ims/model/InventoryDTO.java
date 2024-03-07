package com.my.ims.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class InventoryDTO implements Serializable {

    private static final long serialVersionUID = -2397678789843128779L;

    private String pkInventoryId;
    private String name;
    private String description;
    private Long quantity;
    private BigDecimal price;
    private String category;

    public String getPkInventoryId() {
        return pkInventoryId;
    }

    public void setPkInventoryId(String pkInventoryId) {
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
        InventoryDTO that = (InventoryDTO) o;
        return Objects.equals(pkInventoryId, that.pkInventoryId) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(quantity, that.quantity) && Objects.equals(price, that.price) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkInventoryId, name, description, quantity, price, category);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("InventoryDTO{");
        builder.append("pkInventoryId='").append(pkInventoryId).append('\'');
        builder.append(", name='").append(name).append('\'');
        builder.append(", description='").append(description).append('\'');
        builder.append(", quantity=").append(quantity);
        builder.append(", price=").append(price);
        builder.append(", category='").append(category).append('\'');
        builder.append('}');
        return builder.toString();
    }
}
