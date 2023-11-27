package com.teklik.backend_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teklik.backend_security.model.User;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    Optional<User> findByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);
}
