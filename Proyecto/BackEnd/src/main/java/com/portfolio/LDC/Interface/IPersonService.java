package com.portfolio.LDC.Interface;

import com.portfolio.LDC.Entity.Person;
import java.util.List;


/**
 *
 * @author lucas
 */

public interface IPersonService {
    //Traer person
    public List<Person> getPerson();
    
    //Guardar person
    public void savePerson(Person person);
    
    //Eliminar un objeto por ID
    public void deletePerson(Long id);
    
    //Buscar person por ID
    public Person findPerson(Long id);
    
}
