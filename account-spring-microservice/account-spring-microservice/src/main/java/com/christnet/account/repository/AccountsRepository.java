package com.christnet.account.repository;

import com.christnet.account.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    Accounts findByCustomerId(int customerId);
}
