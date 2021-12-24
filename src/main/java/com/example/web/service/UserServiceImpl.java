package com.example.web.service;


import com.example.web.dao.UserDaoRepository;
import com.example.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDaoRepository userDaoRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDaoRepository userDaoRepository, PasswordEncoder passwordEncoder) {
        this.userDaoRepository = userDaoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDaoRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDaoRepository.saveAndFlush(user);
    }

    @Override
    public void removeUserById(long id) {
        userDaoRepository.deleteById(id);
    }

    @Override
    @Transactional (readOnly = true)
    public User getUserById(long id) {
        return userDaoRepository.getById(id);
    }

    @Override
    @Transactional (readOnly = true)
    public List<User> getAllUsers() {
        return userDaoRepository.findAll();
    }

}
