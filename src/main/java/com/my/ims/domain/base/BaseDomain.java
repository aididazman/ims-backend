package com.my.ims.domain.base;

import jakarta.persistence.Column;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public abstract class BaseDomain implements Serializable {

    private static final long serialVersionUID = 5411963629582360949L;

    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private Long createdBy;

    @LastModifiedBy
    @Column(name = "modified_by", length = 50)
    private Date modifiedBy;

    @Column(name = "modified_date")
    private Long modifiedDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Date modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Long modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseDomain that = (BaseDomain) o;
        return Objects.equals(createdDate, that.createdDate)
                && Objects.equals(createdBy, that.createdBy)
                && Objects.equals(modifiedBy, that.modifiedBy)
                && Objects.equals(modifiedDate, that.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdDate, createdBy, modifiedBy, modifiedDate);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("BaseDomain{");
        builder.append("createdDate=").append(createdDate);
        builder.append(", createdBy=").append(createdBy);
        builder.append(", modifiedBy=").append(modifiedBy);
        builder.append(", modifiedDate=").append(modifiedDate);
        builder.append('}');
        return builder.toString();
    }
}
