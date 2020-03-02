package edu.stev.cursach.service.group.interfaces;

import edu.stev.cursach.model.Group;

import java.util.List;

//declaration 5 meths of CRUD
public interface IGroupService<T> {
    T save(T element); //create
    T get(String id);
    List<T> getAll();
    T edit(T element); //update
    boolean delete(String id); //delete
}
