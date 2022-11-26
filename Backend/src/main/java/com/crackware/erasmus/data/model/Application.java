package com.crackware.erasmus.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Student student;

    @Enumerated(EnumType.STRING)
    private Department department;

    @ElementCollection(targetClass= School.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="application_schools")
    @Column(name="schools")
    private Set<School> schools;

    private double points;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private School admittedSchool;

    private Date date;
}