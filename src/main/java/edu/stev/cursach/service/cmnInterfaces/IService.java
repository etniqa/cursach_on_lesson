package edu.stev.cursach.service.cmnInterfaces;

import java.util.List;

//declaration 5 meths of CRUD
public interface IService<T> {
    T save(T element); //create
    T get(String id); //read
    List<T> getAll();
    T edit(T element); //update
    T delete(T element); //delete
}
