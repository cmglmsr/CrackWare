package com.crackware.erasmus.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
/**
 * Class which contains properties and functions for WaitList class
 */
public class WaitList extends List {
    @OneToMany
    private Set<Application> applications;
}
