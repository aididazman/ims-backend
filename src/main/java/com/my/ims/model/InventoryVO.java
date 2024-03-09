package com.my.ims.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class InventoryVO implements Serializable {

    private static final long serialVersionUID = 4744240818056752948L;

    private String pkProductId;
    private List<String> pkProductList;
    private ProductDTO productDTO;

    private String pkSupplierId;
    private List<String> pkSupplierList;
    private SupplierDTO supplierDTO;

    private InventoryItemDTO inventoryItemDTO;
    private List<InventoryItemDTO> inventoryItemListDTO;

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

    public InventoryItemDTO getInventoryItemDTO() {
        return inventoryItemDTO;
    }

    public void setInventoryItemDTO(InventoryItemDTO inventoryItemDTO) {
        this.inventoryItemDTO = inventoryItemDTO;
    }

    public List<InventoryItemDTO> getInventoryItemListDTO() {
        return inventoryItemListDTO;
    }

    public void setInventoryItemListDTO(List<InventoryItemDTO> inventoryItemListDTO) {
        this.inventoryItemListDTO = inventoryItemListDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryVO that = (InventoryVO) o;
        return Objects.equals(pkProductId, that.pkProductId)
                && Objects.equals(pkProductList, that.pkProductList)
                && Objects.equals(productDTO, that.productDTO)
                && Objects.equals(pkSupplierId, that.pkSupplierId)
                && Objects.equals(pkSupplierList, that.pkSupplierList)
                && Objects.equals(supplierDTO, that.supplierDTO)
                && Objects.equals(inventoryItemDTO, that.inventoryItemDTO)
                && Objects.equals(inventoryItemListDTO, that.inventoryItemListDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkProductId, pkProductList, productDTO, pkSupplierId,
                pkSupplierList, supplierDTO, inventoryItemDTO, inventoryItemListDTO);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InventoryVO{");
        sb.append("pkProductId='").append(pkProductId).append('\'');
        sb.append(", pkProductList=").append(pkProductList);
        sb.append(", productDTO=").append(productDTO);
        sb.append(", pkSupplierId='").append(pkSupplierId).append('\'');
        sb.append(", pkSupplierList=").append(pkSupplierList);
        sb.append(", supplierDTO=").append(supplierDTO);
        sb.append(", inventoryItemDTO=").append(inventoryItemDTO);
        sb.append(", inventoryItemListDTO=").append(inventoryItemListDTO);
        sb.append('}');
        return sb.toString();
    }
}
