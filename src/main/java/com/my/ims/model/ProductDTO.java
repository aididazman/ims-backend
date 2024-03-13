package com.my.ims.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ProductDTO implements Serializable {

    private static final long serialVersionUID = -2397678789843128779L;

    private String pkProductId;
    private String productName;
    private String description;
    private Long quantity;
    private BigDecimal price;
    private String category;
    private List<SupplierDTO> supplierListDTO;

    public String getPkProductId() {
        return pkProductId;
    }

    public void setPkProductId(String pkProductId) {
        this.pkProductId = pkProductId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public List<SupplierDTO> getSupplierListDTO() {
        return supplierListDTO;
    }

    public void setSupplierListDTO(List<SupplierDTO> supplierListDTO) {
        this.supplierListDTO = supplierListDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return Objects.equals(pkProductId, that.pkProductId)
                && Objects.equals(productName, that.productName)
                && Objects.equals(description, that.description)
                && Objects.equals(quantity, that.quantity)
                && Objects.equals(price, that.price)
                && Objects.equals(category, that.category)
                && Objects.equals(supplierListDTO, that.supplierListDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkProductId, productName, description, quantity, price, category, supplierListDTO);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductDTO{");
        sb.append("pkProductId='").append(pkProductId).append('\'');
        sb.append(", productName='").append(productName).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", price=").append(price);
        sb.append(", category='").append(category).append('\'');
        sb.append(", supplierListDTO=").append(supplierListDTO);
        sb.append('}');
        return sb.toString();
    }
}
