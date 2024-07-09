package org.shoponline.shoponline.repository;

import org.shoponline.shoponline.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String username);
}
