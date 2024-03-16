package com.my.ims.model.inventory;

import com.my.ims.domain.inventory.TbTProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class InventoryVO implements Serializable {

    private static final long serialVersionUID = 4744240818056752948L;

    private String pkProductId;
    private List<String> pkProductList;
    private ProductDTO productDTO;
    private List<ProductDTO> productListDTO;
    private Page<TbTProduct> productPaginated;
    private Pageable productPageable;

    private String pkSupplierId;
    private List<String> pkSupplierList;
    private SupplierDTO supplierDTO;
    private List<SupplierDTO> supplierListDTO;

    private Boolean status;

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

    public List<String> getPkProductList() {
        return pkProductList;
    }

    public void setPkProductList(List<String> pkProductList) {
        this.pkProductList = pkProductList;
    }

    public List<String> getPkSupplierList() {
        return pkSupplierList;
    }

    public void setPkSupplierList(List<String> pkSupplierList) {
        this.pkSupplierList = pkSupplierList;
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
                && Objects.equals(pkProductList, that.pkProductList)
                && Objects.equals(productDTO, that.productDTO)
                && Objects.equals(productListDTO, that.productListDTO)
                && Objects.equals(pkSupplierId, that.pkSupplierId)
                && Objects.equals(pkSupplierList, that.pkSupplierList)
                && Objects.equals(supplierDTO, that.supplierDTO)
                && Objects.equals(supplierListDTO, that.supplierListDTO)
                && Objects.equals(status, that.status)
                && Objects.equals(productPaginated, that.productPaginated)
                && Objects.equals(productPageable, that.productPageable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkProductId, pkProductList, productDTO, productListDTO, pkSupplierId,
                pkSupplierList, supplierDTO, supplierListDTO, status, productPaginated, productPageable);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InventoryVO{");
        sb.append("pkProductId='").append(pkProductId).append('\'');
        sb.append(", pkProductList=").append(pkProductList);
        sb.append(", productDTO=").append(productDTO);
        sb.append(", productListDTO=").append(productListDTO);
        sb.append(", pkSupplierId='").append(pkSupplierId).append('\'');
        sb.append(", pkSupplierList=").append(pkSupplierList);
        sb.append(", supplierDTO=").append(supplierDTO);
        sb.append(", supplierListDTO=").append(supplierListDTO);
        sb.append(", status=").append(status);
        sb.append(", productPaginated=").append(productPaginated);
        sb.append(", productPageable=").append(productPageable);
        sb.append('}');
        return sb.toString();
    }
}
