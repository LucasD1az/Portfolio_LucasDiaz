package com.portfolio.LDC.Controller;

import com.portfolio.LDC.Dto.dtoPerson;
import com.portfolio.LDC.Entity.Person;
import com.portfolio.LDC.Security.Controller.Mensaje;
import com.portfolio.LDC.Service.ImpPersonService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lucas
 */
@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = {"https://frontend-ap-8746a.web.app", "http://localhost:4200"})
public class PersonController {
    @Autowired
    ImpPersonService personService;

    @GetMapping("/lista")
    public ResponseEntity<List<Person>> list() {
        List<Person> list = personService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") int id) {
        if (!personService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        Person person = personService.getOne(id).get();
        return new ResponseEntity(person, HttpStatus.OK);
    }

    /*@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPerson dtoperson) {
        if (StringUtils.isBlank(dtoperson.getNameE())) {
            return new ResponseEntity(new Mensaje("El nombre es requerido"), HttpStatus.BAD_REQUEST);
        }
        if (personService.existsByNameE(dtoperson.getNameE())) {
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        Person experience = new Person(dtoperson.getNameE(), dtoperson.getDescriptionE());
        personService.save(experience);

        return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.OK);
    }*/

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPerson dtoperson) {
        if (!personService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        if (personService.existsByFirstName(dtoperson.getFirstName()) && personService.getByFirstName(dtoperson.getFirstName()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoperson.getFirstName())) {
            return new ResponseEntity(new Mensaje("El nombre es requerido"), HttpStatus.BAD_REQUEST);
        }

        Person person = personService.getOne(id).get();
        person.setFirstName(dtoperson.getFirstName());
        person.setLastName(dtoperson.getLastName());
        person.setDescription(dtoperson.getDescription());
        person.setImg(dtoperson.getImg());

        personService.save(person);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);

    }
    
    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!personService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        personService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }*/
}

