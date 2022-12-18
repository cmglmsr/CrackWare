package com.crackware.erasmus.data.model;

import com.crackware.erasmus.data.model.enums.Department;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Coordinator extends BaseEntity {

    private Department department;

    @ManyToOne(cascade = CascadeType.ALL)
    private ToDoList toDoList;


}
