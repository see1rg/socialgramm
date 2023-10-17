package com.see1rg.socialgramm.service;


import com.see1rg.socialgramm.entity.User;
import com.see1rg.socialgramm.exceptions.UserAlreadyExistsException;
import com.see1rg.socialgramm.payload.request.SignupRequest;
import com.see1rg.socialgramm.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public static final Logger log = LogManager.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(SignupRequest signupRequest) {

        User user = new User();
                user.setEmail(signupRequest.getEmail());
                user.setUsername(signupRequest.getUsername());
                user.setName(signupRequest.getFirstname());
                user.setLastName(signupRequest.getLastname());
                user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        try {
            log.info("Creating user: {} ", signupRequest.getEmail());
            return userRepository.save(user);
        }
        catch (Exception e){
            log.error("Error creating user: {} ", e.getMessage());
            throw new UserAlreadyExistsException("The user "  + user.getUsername() +
                    " already exists, please check credentials!");
        }
    }
}
