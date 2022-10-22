package com.portfolio.LDC.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lucas
 */
@Getter @Setter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String firstName;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String lastName;
    
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String img;
    
    
}
