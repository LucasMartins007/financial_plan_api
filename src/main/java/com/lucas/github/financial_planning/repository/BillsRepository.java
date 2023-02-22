package com.lucas.github.financial_planning.repository;

import com.lucas.github.financial_planning.model.entity.Bills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BillsRepository extends JpaRepository<Bills, Integer> {
}
