package com.my.ims.domain.auth;

import com.my.ims.domain.base.BaseDomain;
import com.my.ims.util.constants.TableConstants;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = TableConstants.TB_T_USER)
public class TbTUser extends BaseDomain {

    private static final long serialVersionUID = -9186347470760560332L;

    @Id
    @Column(name = "pk_userid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkUserId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = TableConstants.TB_M_USERROLE,  // Name of the join table
            joinColumns = @JoinColumn(name = "user_id"),  // Name of the foreign key column for User
            inverseJoinColumns = @JoinColumn(name = "role_id")  // Name of the foreign key column for Role
    )
    private Set<TbTRole> tbTRole = new HashSet<>();

    public Long getPkUserId() {
        return pkUserId;
    }

    public void setPkUserId(Long pkUserId) {
        this.pkUserId = pkUserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<TbTRole> getTbTRole() {
        return tbTRole;
    }

    public void setTbTRole(Set<TbTRole> tbTRole) {
        this.tbTRole = tbTRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TbTUser tbTUser = (TbTUser) o;
        return Objects.equals(pkUserId, tbTUser.pkUserId)
                && Objects.equals(username, tbTUser.username)
                && Objects.equals(email, tbTUser.email)
                && Objects.equals(password, tbTUser.password)
                && Objects.equals(tbTRole, tbTUser.tbTRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pkUserId, username, email, password, tbTRole);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("TbTUser{");
        builder.append("pkUserId=").append(pkUserId);
        builder.append(", username='").append(username).append('\'');
        builder.append(", email='").append(email).append('\'');
        builder.append(", password='").append(password).append('\'');
        builder.append(", tbTRole=").append(tbTRole);
        builder.append('}');
        return builder.toString();
    }
}
