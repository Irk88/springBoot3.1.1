package com.example.web.service;

import com.example.web.dao.RoleDaoRepository;
import com.example.web.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    private final RoleDaoRepository roleDaoRepository;

    @Autowired
    public RoleServiceImpl(RoleDaoRepository roleDaoRepository) {
        this.roleDaoRepository = roleDaoRepository;
    }

    @Override
    @Transactional (readOnly = true)
    public List<Role> getAllRoles() {
        return roleDaoRepository.findAll();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDaoRepository.getRoleByRoleName(name);
    }

    @Override
    public Set<Role> getSetOfRoles(String[] roleNames) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : roleNames) {
            roleSet.add(getRoleByName(role));
        }
        return roleSet;
    }
}
