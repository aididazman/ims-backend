package com.my.ims.auth.role;

import com.my.ims.base.domain.BaseDomain;
import com.my.ims.util.constants.TableConstants;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = TableConstants.TB_T_ROLE)
public class TbTRole extends BaseDomain {

    private static final long serialVersionUID = -7157396458441559576L;

    @Id
    @Column(name = "pk_roleid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkRoleId;

    @Column(name="role_name", nullable = false)
    private String roleName;

    @Column(name="description")
    private String description;

    @Column(name="isadmin")
    private Boolean isAdmin;

    public Long getPkRoleId() {
        return pkRoleId;
    }

    public void setPkRoleId(Long pkRoleId) {
        this.pkRoleId = pkRoleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TbTRole tbTRole = (TbTRole) o;
        return Objects.equals(pkRoleId, tbTRole.pkRoleId)
                && Objects.equals(roleName, tbTRole.roleName)
                && Objects.equals(description, tbTRole.description)
                && Objects.equals(isAdmin, tbTRole.isAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pkRoleId, roleName, description, isAdmin);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("TbTRole{");
        builder.append("pkRoleId=").append(pkRoleId);
        builder.append(", roleName='").append(roleName).append('\'');
        builder.append(", description='").append(description).append('\'');
        builder.append(", isAdmin=").append(isAdmin);
        builder.append('}');
        return builder.toString();
    }
}
