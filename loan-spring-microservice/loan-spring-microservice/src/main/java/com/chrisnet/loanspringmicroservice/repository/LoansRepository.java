package com.chrisnet.loanspringmicroservice.repository;

import com.chrisnet.loanspringmicroservice.model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoansRepository extends JpaRepository<Loans, Integer> {

    List<Loans> findByCustomerIdOrderByStartDtDesc(int customer_id);

}
