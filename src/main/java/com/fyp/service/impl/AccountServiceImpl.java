package com.fyp.service.impl;

import com.fyp.dto.AccountDTO;
import com.fyp.entity.Account;
import com.fyp.mapper.AccountMapper;
import com.fyp.repository.AccountRepository;
import com.fyp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountMapper accountMapper;
//
//    @Autowired
//    LecturerMapper lecturerMapper;
//
//    @Autowired
//    StudentMapper studentMapper;
//
//    @Autowired
//    AdministratorMapper administratorMapper;
//
//    @Autowired
//    EnrollmentMapper enrollmentMapper;

    // Read operation (getAll)
    @Override
    public List<AccountDTO> readAccountList() {
        return accountMapper.entityToDTOList(accountRepository.findAllByIsDeletedFalseOrderByAccId());
    }

    // Read operation (by ID)
    @Override
    public AccountDTO findById(Long id) {
        return accountMapper.entityToDTO(accountRepository.findByAccIdAndIsDeletedFalse(id));
    }

    // Create operation
    @Override
    public Account createAccount(Account account) {
        String usertype = account.getAcc_usertype();

        Account checkDuplicate = accountRepository.findByAccUsernameAndIsDeletedFalse(account.getAccUsername());

        if (checkDuplicate != null) {
            return null;
        }

        if (usertype.equals("lecturer")) {
            account.getLecturer().setIsDeleted(false);
            account.getLecturer().setLect_id_number(account.getLecturer().getLect_id_number());
            account.getLecturer().setAccount(account);
            // Set Admin and Student to null since usertype = lecturer
            account.setAdministrator(null);
            account.setStudent(null);
        } else if (usertype.equals("student")) {
            account.getStudent().setIsDeleted(false);
            account.getStudent().setStdn_id_number(account.getStudent().getStdn_id_number());
            account.getStudent().setAccount(account);
            // Set Admin and Lecturer to null since usertype = student
            account.setAdministrator(null);
            account.setLecturer(null);
        } else if (usertype.equals("administrator")) {
            // administrator
            account.getAdministrator().setIsDeleted(false);
            account.getAdministrator().setAdm_id_number(account.getAdministrator().getAdm_id_number());
            account.getAdministrator().setAccount(account);
            // Set Lecturer and Student to null since usertype = administrator
            account.setLecturer(null);
            account.setStudent(null);
        } else {
            return null;
        }

        account.setIsDeleted(false);
        return accountRepository.save(account);
    }

    // Update operation
    @Override
    public Account updateAccount(Account account, Long id) {
        Account accountToUpdate = accountRepository.findByAccIdAndIsDeletedFalse(id);
        String usertype = account.getAcc_usertype();

        switch (usertype) {
            case "lecturer":
                accountToUpdate.getLecturer().setIsDeleted(false);
                accountToUpdate.getLecturer().setLect_id_number(account.getLecturer().getLect_id_number());
                accountToUpdate.getLecturer().setLect_firstname(account.getLecturer().getLect_firstname());
                accountToUpdate.getLecturer().setLect_lastname(account.getLecturer().getLect_lastname());
                accountToUpdate.getLecturer().setLect_email(account.getLecturer().getLect_email());
                accountToUpdate.getLecturer().setLect_dob(account.getLecturer().getLect_dob());
                accountToUpdate.getLecturer().setLect_gender(account.getLecturer().getLect_gender());
                break;
            case "student":
                accountToUpdate.getStudent().setIsDeleted(false);
                accountToUpdate.getStudent().setStdn_id_number(account.getStudent().getStdn_id_number());
                accountToUpdate.getStudent().setStdn_firstname(account.getStudent().getStdn_firstname());
                accountToUpdate.getStudent().setStdn_lastname(account.getStudent().getStdn_lastname());
                accountToUpdate.getStudent().setStdn_email(account.getStudent().getStdn_email());
                accountToUpdate.getStudent().setStdn_dob(account.getStudent().getStdn_dob());
                accountToUpdate.getStudent().setStdn_gender(account.getStudent().getStdn_gender());
                break;
            case "administrator":
                // administrator
                accountToUpdate.getAdministrator().setIsDeleted(false);
                accountToUpdate.getAdministrator().setAdm_id_number(account.getAdministrator().getAdm_id_number());
                break;
            default:
                return null;
        }

        accountToUpdate.setAccPassword(account.getAccPassword());
        return accountRepository.save(accountToUpdate);
    }

    // Delete operation
    @Override
    public Account deleteAccount(Long id) {
        Account accountToDelete = accountRepository.findByAccIdAndIsDeletedFalse(id);
        accountToDelete.setIsDeleted(true);
        return accountRepository.save(accountToDelete);
    }
}