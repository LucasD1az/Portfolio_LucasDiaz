package com.portfolio.LDC.Repository;

import com.portfolio.LDC.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucas
 */
@Repository
public interface IPersonRepository extends JpaRepository<Person, Long>{
    
}
