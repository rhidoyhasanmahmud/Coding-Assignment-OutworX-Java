package com.codemechanix.codingchallenge.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "department")
@Getter
@Setter
@ToString
public class Department implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departmentid")
    Long id ;

    @Column(name = "departmentname", unique = true)
    @Size(max = 4000, message = "{validation.name.size.too_long}")
    String departmentName;
}
