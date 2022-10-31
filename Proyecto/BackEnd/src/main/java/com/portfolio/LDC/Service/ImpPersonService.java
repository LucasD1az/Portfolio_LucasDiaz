package com.portfolio.LDC.Service;

import com.portfolio.LDC.Entity.Person;
import com.portfolio.LDC.Repository.IPersonRepository;
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
public class ImpPersonService {

    @Autowired
    IPersonRepository ipersonRepository;

    public List<Person> list() {
        return ipersonRepository.findAll();
    }

    public Optional<Person> getOne(int id) {
        return ipersonRepository.findById(id);
    }

    public Optional<Person> getByFirstName(String firstName) {
        return ipersonRepository.findByFirstName(firstName);
    }

    public void save(Person person) {
        ipersonRepository.save(person);
    }

    public void delete(int id) {
        ipersonRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return ipersonRepository.existsById(id);
    }

    public boolean existsByFirstName(String firstName) {
        return ipersonRepository.existsByFirstName(firstName);
    }
}
