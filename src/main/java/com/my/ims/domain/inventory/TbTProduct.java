package com.my.ims.domain.inventory;

import com.my.ims.domain.base.BaseDomain;
import com.my.ims.util.constants.TableConstants;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = TableConstants.TB_T_PRODUCT)
public class TbTProduct extends BaseDomain {

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

    @Column(name = "status")
    private Boolean status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = TableConstants.TB_M_PRODUCTSUPPLY,  // Name of the join table
            joinColumns = @JoinColumn(name = "product_id"),  // Name of the foreign key column for User
            inverseJoinColumns = @JoinColumn(name = "supply_id")  // Name of the foreign key column for Role
    )
    private Set<TbTSupplier> tbTSupplierList = new HashSet<>();

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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Set<TbTSupplier> getTbTSupplierList() {
        return tbTSupplierList;
    }

    public void setTbTSupplierList(Set<TbTSupplier> tbTSupplierList) {
        this.tbTSupplierList = tbTSupplierList;
    }

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
                && Objects.equals(status, that.status)
                && Objects.equals(tbTSupplierList, that.tbTSupplierList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pkProductId, productName, description, quantity,
                price, category, status, tbTSupplierList);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TbTProduct{");
        sb.append("pkProductId='").append(pkProductId).append('\'');
        sb.append(", productName='").append(productName).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", price=").append(price);
        sb.append(", category='").append(category).append('\'');
        sb.append(", status=").append(status);
        sb.append(", tbTSupplierList=").append(tbTSupplierList);
        sb.append('}');
        return sb.toString();
    }
}
