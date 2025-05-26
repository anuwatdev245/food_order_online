package com.anuwat.food_order_online.service;

import com.anuwat.food_order_online.config.JwtProvider;
import com.anuwat.food_order_online.model.User;
import com.anuwat.food_order_online.repository.UserRepository;

public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    private final JwtProvider jwtProvider;

    public UserServiceImp(UserRepository userRepository, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public User findUserByJwtToken(String jwt) throws Exception {

        String email = jwtProvider.getEmailFromJwtTopken(jwt);
        User user = userRepository.findByEmail(email);

        return user;
    }

    @Override
    public User findUserByEmail(String email) throws Exception {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new Exception("User not found");
        }

        return user;
    }
}
