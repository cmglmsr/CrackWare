package com.crackware.erasmus.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
/**
 * Class which contains properties and functions for ApplicationList class
 */
public class ApplicationList extends List{
    @OneToMany
    private Set<Application> applications;
}
