/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.LDC.Security.Repository;

import com.portfolio.LDC.Security.Entity.Role;
import com.portfolio.LDC.Security.Erums.RoleName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucas
 */
@Repository
public interface iRoleRepository extends JpaRepository<Role, Integer>{
    Optional<Role> findByRoleName(RoleName roleName);
}
