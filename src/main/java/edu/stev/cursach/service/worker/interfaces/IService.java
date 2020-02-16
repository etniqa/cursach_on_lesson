package edu.stev.cursach.service.worker.interfaces;

import java.util.List;

//declaration 5 meths of CRUD
public interface IService<T> {
    T save (T element); //create
    T get(String is); //read
    List<T> getAll();
    T edit(T element); //update
    T delete(T element); //delete
}
