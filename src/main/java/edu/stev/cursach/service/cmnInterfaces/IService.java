package edu.stev.cursach.service.cmnInterfaces;

import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.cmnInterfaces.ICommonFields;

import java.time.LocalDateTime;
import java.util.List;

//declaration 5 methods of CRUD
public interface IService<T extends ICommonFields> {
    IDao getDao();

    default T save(T element){
        element.setCreationDate(LocalDateTime.now());
        element.setDateModified(LocalDateTime.now());
        return (T) getDao().save(element);
    } //create
    default T get(String id){
        System.out.println("get form IService");
        return (T) getDao().get(id);
    } //read
    default List<T> getAll(){
        return getDao().getAll();
    } //update
    T edit(T element);
    default void delete(String id){ //delete
        System.out.println("delete from IService");
        getDao().delete(id);
    }
}
