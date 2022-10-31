package com.portfolio.LDC.Repository;

import com.portfolio.LDC.Entity.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucas
 */
@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer>{
    public Optional<Person> findByFirstName(String firstName);
    public boolean existsByFirstName(String firstName);    
}
