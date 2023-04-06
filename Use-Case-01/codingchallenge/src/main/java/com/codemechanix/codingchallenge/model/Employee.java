package com.codemechanix.codingchallenge.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "employee")
@Getter
@Setter
@ToString
public class Employee implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeid")
    Long id;

    @Column(name = "firstname")
    @Size(max = 4000, message = "{validation.name.size.too_long}")
    private String firstName;

    @Column(name = "lastname")
    @Size(max = 4000, message = "{validation.name.size.too_long}")
    private String lastName;

    @Column(name = "department")
    @Size(max = 4000, message = "{validation.name.size.too_long}")
    private String department;
}
