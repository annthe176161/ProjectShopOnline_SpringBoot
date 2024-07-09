package org.shoponline.shoponline.service;

import org.shoponline.shoponline.model.UserRoleMap;
import org.shoponline.shoponline.repository.UserRoleMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleMapService {

    @Autowired
    private UserRoleMapRepository userRoleMapRepository;

    public void saveUserRoleMap(UserRoleMap userRoleMap) {
        userRoleMapRepository.save(userRoleMap);
    }
}