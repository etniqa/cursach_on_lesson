package edu.stev.cursach.dao.worker.interfaces;

import java.util.List;

public interface IDao<T> {
    T save (T element); //create
    T get(String is); //read
    List<T> getAll();
    T edit(T element); //update
    T delete(T element); //delete
}
