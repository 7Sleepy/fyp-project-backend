package com.fyp.repository;

import com.fyp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByAccIdAndIsDeletedFalse(Long id);

    Account findByAccUsernameAndIsDeletedFalse(String username);

    Optional<Account> findByAccUsernameAndAccPassword(String username, String password);

    @Query("SELECT a FROM Account a WHERE a.accUsername = :username")
    Optional<Account> findByAccUsernameAndIsDeletedFalseCustom(@Param("username") String username);

    List<Account> findAllByIsDeletedFalseOrderByAccId();

}
