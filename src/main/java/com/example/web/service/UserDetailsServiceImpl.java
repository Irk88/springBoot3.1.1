package com.example.web.service;

import com.example.web.dao.UserDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDaoRepository userDaoRepository;

    @Autowired
    public UserDetailsServiceImpl(UserDaoRepository userDaoRepository) {
        this.userDaoRepository = userDaoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDaoRepository.getUserByName(username);
    }
}
