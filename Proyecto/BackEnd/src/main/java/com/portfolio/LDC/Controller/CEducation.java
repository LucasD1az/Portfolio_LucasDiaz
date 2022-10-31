/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.LDC.Controller;

import com.portfolio.LDC.Dto.dtoEducation;
import com.portfolio.LDC.Entity.Education;
import com.portfolio.LDC.Security.Controller.Mensaje;
import com.portfolio.LDC.Security.Service.SEducation;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins="https://frontend-ap-8746a.web.app")
public class CEducation {
    @Autowired
    SEducation sEducation;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Education>> list(){
        List<Education> list=sEducation.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id){
        if(!sEducation.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Education education=sEducation.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducation.existsById(id))
            return new ResponseEntity(new Mensaje("NO existe el ID"), HttpStatus.NOT_FOUND);
        sEducation.delete(id);
        return new ResponseEntity(new Mensaje("Educación eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducation dtoeducation){
        if(StringUtils.isBlank(dtoeducation.getNameE())){
            return new ResponseEntity(new Mensaje("El nombre es requerido"), HttpStatus.BAD_REQUEST);
        }
        if(sEducation.existsByNameE(dtoeducation.getNameE())){
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        Education education = new Education(
                dtoeducation.getNameE(), dtoeducation.getDescriptionE()
        );
        sEducation.save(education);
        return new ResponseEntity(new Mensaje("Educación creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducation dtoeducation){
        if(!sEducation.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sEducation.existsByNameE(dtoeducation.getNameE())&&sEducation.getByNameE(dtoeducation.getNameE()).get().getId()!= id){
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducation.getNameE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        Education education = sEducation.getOne(id).get();
        
        education.setNameE(dtoeducation.getNameE());
        education.setDescriptionE(dtoeducation.getDescriptionE());
        
        sEducation.save(education);
        
        return new ResponseEntity(new Mensaje("Educación actualizada"), HttpStatus.OK);
        
    }
}
