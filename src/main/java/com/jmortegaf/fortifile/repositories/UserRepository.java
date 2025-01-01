package com.jmortegaf.fortifile.repositories;

import com.jmortegaf.fortifile.models.User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String tokenSubject);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String username);
}
