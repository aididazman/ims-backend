package com.my.ims.base.domain;

import com.my.ims.util.CommonUtil;
import com.my.ims.util.constants.DbStatusEnum;
import jakarta.persistence.*;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

@MappedSuperclass
public abstract class BaseDomain implements Serializable {

    @Serial
    private static final long serialVersionUID = 5411963629582360949L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @LastModifiedBy
    @Column(name = "modified_by", length = 50)
    private String modifiedBy;

    @Column(name = "status")
    private Integer status = DbStatusEnum.ACTIVE.getValue();

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Integer getStatus() { return status; }

    public void setStatus(Integer status) { this.status = status; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseDomain that = (BaseDomain) o;
        return Objects.equals(createdDate, that.createdDate)
                && Objects.equals(createdBy, that.createdBy)
                && Objects.equals(modifiedDate, that.modifiedDate)
                && Objects.equals(modifiedBy, that.modifiedBy)
                && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdDate, createdBy, modifiedDate, modifiedBy, status);
    }


    @PrePersist
    private void onSave() {
        this.createdDate = LocalDateTime.now(ZoneId.systemDefault());
        this.createdBy = CommonUtil.getCurrentUser();
        this.modifiedDate = LocalDateTime.now(ZoneId.systemDefault());
        this.modifiedBy = CommonUtil.getCurrentUser();
    }

    @PreUpdate
    private void onUpdate() {
        this.modifiedDate = LocalDateTime.now(ZoneId.systemDefault());
        this.modifiedBy = CommonUtil.getCurrentUser();
    }

}
