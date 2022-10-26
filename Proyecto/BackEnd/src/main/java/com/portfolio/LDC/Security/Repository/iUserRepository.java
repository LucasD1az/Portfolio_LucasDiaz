/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.LDC.Security.Repository;

import com.portfolio.LDC.Security.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucas
 */
@Repository
public interface iUserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUserName(String userName);
    
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
}
