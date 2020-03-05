package edu.stev.cursach.service.cmnInterfaces;

import edu.stev.cursach.dao.cmnInterfaces.IDao;

import java.util.List;

//declaration 5 meths of CRUD
public interface IService<T> {
    IDao getDao();

    default T save(T element){
        return (T) getDao().save(element);
    } //create
    default T get(String id){
        System.out.println("get form IService");
        return (T) getDao().get(id);
    } //read
    default List<T> getAll(){
        return getDao().getAll();
    }
    T edit(T element); //update
    default void delete(String id){
        System.out.println("delete from IService");
        getDao().delete(id);
    } //delete
}
