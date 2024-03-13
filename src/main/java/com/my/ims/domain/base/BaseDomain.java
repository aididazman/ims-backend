package com.my.ims.domain.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.time.Instant;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public abstract class BaseDomain implements Serializable {

    private static final long serialVersionUID = 5411963629582360949L;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Instant createdDate;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private Long createdBy;

    @LastModifiedDate
    @Column(name = "modified_date")
    private Instant modifiedDate;

    @LastModifiedBy
    @Column(name = "modified_by", length = 50)
    private Long modifiedBy;

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Instant modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseDomain that = (BaseDomain) o;
        return Objects.equals(createdDate, that.createdDate)
                && Objects.equals(createdBy, that.createdBy)
                && Objects.equals(modifiedDate, that.modifiedDate)
                && Objects.equals(modifiedBy, that.modifiedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdDate, createdBy, modifiedDate, modifiedBy);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseDomain{");
        sb.append("createdDate=").append(createdDate);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", modifiedDate=").append(modifiedDate);
        sb.append(", modifiedBy=").append(modifiedBy);
        sb.append('}');
        return sb.toString();
    }
}
