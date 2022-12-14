package com.crackware.erasmus.data.model;


import com.crackware.erasmus.data.model.security.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@MappedSuperclass
/**
 * Class which contains properties and functions for BaseEntity class
 */
public class BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Role role;

    private String name;

    private String surname;

    private String mail;

    @Lob
    private Byte[] image;

    private String dateOfBirth;

}
