package com.my.ims.model;

import java.io.Serializable;
import java.util.Objects;

public class SupplierDTO implements Serializable {

    private static final long serialVersionUID = 3379939900194449766L;

    private String pkSupplierId;
    private String name;
    private String contactInfo;

    public String getPkSupplierId() {
        return pkSupplierId;
    }

    public void setPkSupplierId(String pkSupplierId) {
        this.pkSupplierId = pkSupplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierDTO that = (SupplierDTO) o;
        return Objects.equals(pkSupplierId, that.pkSupplierId) && Objects.equals(name, that.name) && Objects.equals(contactInfo, that.contactInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkSupplierId, name, contactInfo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SupplierDTO{");
        sb.append("pkSupplierId='").append(pkSupplierId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", contactInfo='").append(contactInfo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
