package com.my.ims.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class ProductDTO implements Serializable {

    private static final long serialVersionUID = -2397678789843128779L;

    private String pkProductId;
    private String name;
    private String description;
    private Long quantity;
    private BigDecimal price;
    private String category;
    private SupplierDTO supplierDTO;

    public String getPkProductId() {
        return pkProductId;
    }

    public void setPkProductId(String pkProductId) {
        this.pkProductId = pkProductId;
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
        ProductDTO that = (ProductDTO) o;
        return Objects.equals(pkProductId, that.pkProductId)
                && Objects.equals(name, that.name)
                && Objects.equals(description, that.description)
                && Objects.equals(quantity, that.quantity)
                && Objects.equals(price, that.price)
                && Objects.equals(category, that.category)
                && Objects.equals(supplierDTO, that.supplierDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkProductId, name, description, quantity, price, category, supplierDTO);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("ProductDTO{");
        builder.append("pkProductId='").append(pkProductId).append('\'');
        builder.append(", name='").append(name).append('\'');
        builder.append(", description='").append(description).append('\'');
        builder.append(", quantity=").append(quantity);
        builder.append(", price=").append(price);
        builder.append(", category='").append(category).append('\'');
        builder.append(", supplierDTO=").append(supplierDTO);
        builder.append('}');
        return builder.toString();
    }
}
