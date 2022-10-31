/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.LDC.Security.Service;

import com.portfolio.LDC.Entity.Education;
import com.portfolio.LDC.Repository.REducation;
import java.util.List;
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
public class SEducation {
    @Autowired
    REducation rEducation;
    
    public List<Education> list(){
        return rEducation.findAll();
    }
    
    public Optional<Education> getOne(int id){
        return rEducation.findById(id);
    }
    
    public Optional<Education> getByNameE(String nameE){
        return rEducation.findByNameE(nameE);
    }
    
    public void save(Education education){
        rEducation.save(education);
    }
    
    public void delete(int id){
        rEducation.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEducation.existsById(id);
    }
    
    public boolean existsByNameE(String nameE){
        return rEducation.existsByNameE(nameE);
    }
}
