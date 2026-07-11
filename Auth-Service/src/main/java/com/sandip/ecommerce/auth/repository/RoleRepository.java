package com.sandip.ecommerce.auth.repository;

import com.sandip.ecommerce.auth.entity.Role;
import com.sandip.ecommerce.auth.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(RoleName roleName);

}