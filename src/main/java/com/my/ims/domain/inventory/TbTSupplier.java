package com.my.ims.domain.inventory;

import com.my.ims.domain.base.BaseDomain;
import com.my.ims.util.constants.TableConstants;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serial;
import java.util.Objects;

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
        if (!super.equals(o)) return false;
        TbTSupplier that = (TbTSupplier) o;
        return Objects.equals(pkSupplierId, that.pkSupplierId) && Objects.equals(name, that.name) && Objects.equals(contactInfo, that.contactInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pkSupplierId, name, contactInfo);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("TbTSupplier{");
        builder.append("pkSupplierId='").append(pkSupplierId).append('\'');
        builder.append(", name='").append(name).append('\'');
        builder.append(", contactInfo='").append(contactInfo).append('\'');
        builder.append('}');
        return builder.toString();
    }
}