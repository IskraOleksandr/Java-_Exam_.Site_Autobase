package com.example.testpostgre.service.appuserservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.testpostgre.reps.user.UserRepository;
import com.example.testpostgre.model.AppUser;

@Service
public class AppUserServiceImpl implements AppUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(AppUser appUser) {
        userRepository.save(appUser);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

}
