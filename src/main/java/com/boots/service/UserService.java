package com.boots.service;

import com.boots.entity.Role;
import com.boots.entity.User;
import com.boots.repository.UserRepository;
import com.boots.service.serviceResponses.RegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public RegistrationResponse saveUser(String username, String password, String passwordConfirm) {
        User userFromDB = userRepository.findByUsername(username);

        if (userFromDB != null) {
            return RegistrationResponse.USER_ALREADY_EXISTS;
        }
        if (!password.equals(passwordConfirm)){
            return RegistrationResponse.PASSWORDS_DO_NOT_MATCH;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPasswordConfirm(passwordConfirm);
        user.setRoles(Arrays.asList(new Role(1L, "USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return RegistrationResponse.OK;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }


}
