package vn.codegym.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.springsecurity.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUserName(String userName);
}
