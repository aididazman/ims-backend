package com.my.ims.auth.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<TbTUser, Long> {

    Optional<TbTUser> findByUsernameOrEmail(String username, String email);

}
