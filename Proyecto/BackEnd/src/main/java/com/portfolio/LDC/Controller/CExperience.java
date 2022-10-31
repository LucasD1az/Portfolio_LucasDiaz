/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.LDC.Controller;

import com.portfolio.LDC.Dto.dtoExperience;
import com.portfolio.LDC.Entity.Experience;
import com.portfolio.LDC.Security.Controller.Mensaje;
import com.portfolio.LDC.Service.SExperience;
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

/**
 *
 * @author lucas
 */
@RestController
@RequestMapping("/exp")
@CrossOrigin(origins = "http://localhost:4200")
public class CExperience {

    @Autowired
    SExperience sExperience;

    @GetMapping("/lista")
    public ResponseEntity<List<Experience>> list() {
        List<Experience> list = sExperience.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") int id) {
        if (!sExperience.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        Experience experience = sExperience.getOne(id).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperience dtoexp) {
        if (StringUtils.isBlank(dtoexp.getNameE())) {
            return new ResponseEntity(new Mensaje("El nombre es requerido"), HttpStatus.BAD_REQUEST);
        }
        if (sExperience.existsByNameE(dtoexp.getNameE())) {
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        Experience experience = new Experience(dtoexp.getNameE(), dtoexp.getDescriptionE());
        sExperience.save(experience);

        return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperience dtoexp) {
        if (!sExperience.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        if (sExperience.existsByNameE(dtoexp.getNameE()) && sExperience.getByNameE(dtoexp.getNameE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoexp.getNameE())) {
            return new ResponseEntity(new Mensaje("El nombre es requerido"), HttpStatus.BAD_REQUEST);
        }

        Experience experience = sExperience.getOne(id).get();
        experience.setNameE(dtoexp.getNameE());
        experience.setDescriptionE(dtoexp.getDescriptionE());

        sExperience.save(experience);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExperience.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        sExperience.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
}
