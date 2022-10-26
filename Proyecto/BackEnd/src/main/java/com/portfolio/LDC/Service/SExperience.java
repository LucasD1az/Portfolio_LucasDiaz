/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.LDC.Service;

import com.portfolio.LDC.Entity.Experience;
import com.portfolio.LDC.Repository.RExperience;
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
public class SExperience {
    @Autowired
    RExperience rExperience;
    
    public List<Experience> list(){
        return rExperience.findAll();
    }
    
    public Optional<Experience> getOne(int id){
        return rExperience.findById(id);
    }
    
    public Optional<Experience> getByNameE(String nameE){
        return rExperience.findByNameE(nameE);
    }
    
    public void save(Experience expe){
        rExperience.save(expe);
    }
    
    public void delete(int id){
        rExperience.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rExperience.existsById(id);
    }
    
    public boolean existsByNameE(String nameE){
        return rExperience.existsByNameE(nameE);
    }
}
