package com.my.ims.inventory;

import com.my.ims.inventory.product.TbTProduct;
import com.my.ims.inventory.product.ProductDTO;
import com.my.ims.inventory.supplier.SupplierDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class InventoryVO implements Serializable {

    private static final long serialVersionUID = 4744240818056752948L;

    private String pkProductId;
    private List<String> pkProductIds;
    private ProductDTO productDTO;
    private List<ProductDTO> productListDTO;
    private Page<TbTProduct> productPaginated;
    private Pageable productPageable;

    private String pkSupplierId;
    private List<String> pkSupplierIds;
    private SupplierDTO supplierDTO;
    private List<SupplierDTO> supplierListDTO;

    private Boolean status = true;

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public SupplierDTO getSupplierDTO() {
        return supplierDTO;
    }

    public void setSupplierDTO(SupplierDTO supplierDTO) {
        this.supplierDTO = supplierDTO;
    }

    public String getPkProductId() {
        return pkProductId;
    }

    public void setPkProductId(String pkProductId) {
        this.pkProductId = pkProductId;
    }

    public String getPkSupplierId() {
        return pkSupplierId;
    }

    public void setPkSupplierId(String pkSupplierId) {
        this.pkSupplierId = pkSupplierId;
    }

    public List<String> getPkProductIds() {
        return pkProductIds;
    }

    public void setPkProductIds(List<String> pkProductIds) {
        this.pkProductIds = pkProductIds;
    }

    public List<String> getPkSupplierIds() {
        return pkSupplierIds;
    }

    public void setPkSupplierIds(List<String> pkSupplierIds) {
        this.pkSupplierIds = pkSupplierIds;
    }

    public List<ProductDTO> getProductListDTO() {
        return productListDTO;
    }

    public void setProductListDTO(List<ProductDTO> productListDTO) {
        this.productListDTO = productListDTO;
    }

    public List<SupplierDTO> getSupplierListDTO() {
        return supplierListDTO;
    }

    public void setSupplierListDTO(List<SupplierDTO> supplierListDTO) {
        this.supplierListDTO = supplierListDTO;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Page<TbTProduct> getProductPaginated() {
        return productPaginated;
    }

    public void setProductPaginated(Page<TbTProduct> productPaginated) {
        this.productPaginated = productPaginated;
    }

    public Pageable getProductPageable() {
        return productPageable;
    }

    public void setProductPageable(Pageable productPageable) {
        this.productPageable = productPageable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryVO that = (InventoryVO) o;
        return Objects.equals(pkProductId, that.pkProductId)
                && Objects.equals(pkProductIds, that.pkProductIds)
                && Objects.equals(productDTO, that.productDTO)
                && Objects.equals(productListDTO, that.productListDTO)
                && Objects.equals(pkSupplierId, that.pkSupplierId)
                && Objects.equals(pkSupplierIds, that.pkSupplierIds)
                && Objects.equals(supplierDTO, that.supplierDTO)
                && Objects.equals(supplierListDTO, that.supplierListDTO)
                && Objects.equals(status, that.status)
                && Objects.equals(productPaginated, that.productPaginated)
                && Objects.equals(productPageable, that.productPageable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkProductId, pkProductIds, productDTO, productListDTO, pkSupplierId,
                pkSupplierIds, supplierDTO, supplierListDTO, status, productPaginated, productPageable);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InventoryVO{");
        sb.append("pkProductId='").append(pkProductId).append('\'');
        sb.append(", pkProductList=").append(pkProductIds);
        sb.append(", productDTO=").append(productDTO);
        sb.append(", productListDTO=").append(productListDTO);
        sb.append(", pkSupplierId='").append(pkSupplierId).append('\'');
        sb.append(", pkSupplierList=").append(pkSupplierIds);
        sb.append(", supplierDTO=").append(supplierDTO);
        sb.append(", supplierListDTO=").append(supplierListDTO);
        sb.append(", status=").append(status);
        sb.append(", productPaginated=").append(productPaginated);
        sb.append(", productPageable=").append(productPageable);
        sb.append('}');
        return sb.toString();
    }
}
