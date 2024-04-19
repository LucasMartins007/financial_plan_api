package com.lucas.github.financial_planning.repository;

import com.lucas.github.financial_planning.model.entity.Bills;
import com.lucas.github.financial_planning.model.entity.Installment;
import com.lucas.github.financial_planning.repository.custom.CustomInstallmentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstallmentRepository extends JpaRepository<Installment, Integer>, JpaSpecificationExecutor<Installment>, CustomInstallmentRepository {

    List<Installment> findAllByBills(Bills bills);
}
