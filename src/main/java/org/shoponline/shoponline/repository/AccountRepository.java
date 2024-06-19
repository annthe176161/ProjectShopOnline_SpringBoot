package org.shoponline.shoponline.repository;

import org.shoponline.shoponline.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
