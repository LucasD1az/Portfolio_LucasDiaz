/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.LDC.Service;

import com.portfolio.LDC.Entity.HyS;
import com.portfolio.LDC.Repository.RHyS;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Transactional
@Service
public class SHyS {
    @Autowired
    RHyS rHyS;
    
    public List<HyS> list(){
        return rHyS.findAll();
    }
    
    public Optional<HyS> getOne(int id){
        return rHyS.findById(id);
    }
    
    public Optional<HyS> getByNombre(String nombre){
        return rHyS.findByNombre(nombre);
    }
    
    public void save(HyS skill){
        rHyS.save(skill);
    }
    
    public void delete(int id){
        rHyS.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHyS.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rHyS.existsByNombre(nombre);
    }
}
