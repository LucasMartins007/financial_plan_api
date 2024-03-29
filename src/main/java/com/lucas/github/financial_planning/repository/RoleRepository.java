package com.lucas.github.financial_planning.repository;

import com.lucas.github.financial_planning.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRoleDescription(String roleDescription);

}
