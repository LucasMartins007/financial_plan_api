package com.lucas.github.financial_planning.repository;

import com.lucas.github.financial_planning.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameAndActiveTrue(String username);
}
