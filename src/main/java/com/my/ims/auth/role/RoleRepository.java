package com.my.ims.auth.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<TbTRole, Long> {

    TbTRole findByRoleName(String roleName);

}
