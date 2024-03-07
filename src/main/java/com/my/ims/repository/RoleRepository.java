package com.my.ims.repository;

import com.my.ims.domain.auth.TbTRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<TbTRole, Long> {

    TbTRole findByRoleName(String roleName);

}
