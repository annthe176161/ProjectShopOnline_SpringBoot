package org.shoponline.shoponline;

import org.shoponline.shoponline.model.Account;
import org.shoponline.shoponline.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {
        Account account = new Account();
        account.setUsername("admin");
        account.setPassword("password");
        account.setEmail("admin@example.com");
        account.setAddress("123 Main St");
        account.setRoleID(1);
        accountRepository.save(account);
    }
}
