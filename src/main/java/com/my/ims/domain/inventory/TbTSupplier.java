package com.my.ims.domain.inventory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.my.ims.domain.base.BaseDomain;
import com.my.ims.util.constants.TableConstants;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = TableConstants.TB_T_SUPPLIER)
public class TbTSupplier extends BaseDomain {

    private static final long serialVersionUID = 7783312009941880890L;

    @Id
    @Column(name = "pk_supplierid")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String pkSupplierId;

    @Column(name = "name")
    private String name;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "status")
    private Integer status;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TbTSupplier that = (TbTSupplier) o;
        return Objects.equals(pkSupplierId, that.pkSupplierId)
                && Objects.equals(name, that.name)
                && Objects.equals(contactInfo, that.contactInfo)
                && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pkSupplierId, name, contactInfo, status);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TbTSupplier{");
        sb.append("pkSupplierId='").append(pkSupplierId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", contactInfo='").append(contactInfo).append('\'');
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
