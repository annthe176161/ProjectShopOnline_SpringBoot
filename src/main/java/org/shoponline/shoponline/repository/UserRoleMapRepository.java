package org.shoponline.shoponline.repository;

import org.shoponline.shoponline.model.UserRoleMap;
import org.shoponline.shoponline.model.UserRoleMapId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleMapRepository extends JpaRepository<UserRoleMap, UserRoleMapId> {
}