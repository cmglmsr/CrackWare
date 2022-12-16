package com.crackware.erasmus.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ToDoListItem> itemSet;

    public void addItem(ToDoListItem toDoListItem){
        if (itemSet != null && !itemSet.contains(toDoListItem)){
            itemSet.add(toDoListItem);
        }
    }


}