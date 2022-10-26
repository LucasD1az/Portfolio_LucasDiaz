/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.LDC.Security.Service;

import com.portfolio.LDC.Security.Entity.Role;
import com.portfolio.LDC.Security.Erums.RoleName;
import com.portfolio.LDC.Security.Repository.iRoleRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
@Transactional
public class RoleService {
    @Autowired
    iRoleRepository iroleRepository;
    
    public Optional<Role> getByRoleName(RoleName roleName){
        return iroleRepository.findByRoleName(roleName);
    }
    
    public void save (Role role){
        iroleRepository.save(role);
    }
}
