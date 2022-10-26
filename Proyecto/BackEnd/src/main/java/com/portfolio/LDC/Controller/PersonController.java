package com.portfolio.LDC.Controller;

import com.portfolio.LDC.Entity.Person;
import com.portfolio.LDC.Interface.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lucas
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {
    @Autowired IPersonService ipersonService;
    
    @GetMapping("/personas/traer")
    public List<Person> getPerson(){
        return ipersonService.getPerson();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPerson(@RequestBody Person person){
        ipersonService.savePerson(person);
        return "La persona fue creada con éxito";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePerson(@PathVariable Long id){
        ipersonService.deletePerson(id);
        return "La persona fue eliminada con éxito";
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Person editPerson(@PathVariable Long id,
                            @RequestParam("first_name") String newFirstName,
                            @RequestParam("last_name") String newLastName,
                            @RequestParam("img") String newImg){
        Person person = ipersonService.findPerson(id);
        
        person.setFirstName(newFirstName);
        person.setLastName(newLastName);
        person.setImg(newImg);
        
        ipersonService.savePerson(person);
        return person;
    }
    
    @GetMapping("/personas/traer/perfil")
    public Person findPerson(){
        return ipersonService.findPerson((long)1);
    }
}

