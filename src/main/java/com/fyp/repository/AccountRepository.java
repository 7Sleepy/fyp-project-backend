package com.fyp.repository;

import com.fyp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByAccId(String id);
    List<Account> findAllByOrderByAccId();
}
