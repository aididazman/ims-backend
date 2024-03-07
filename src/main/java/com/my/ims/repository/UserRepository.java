package com.my.ims.repository;

import com.my.ims.domain.auth.TbTUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<TbTUser, Long> {

    Optional<TbTUser> findByUsernameOrEmail(String username, String email);

}
