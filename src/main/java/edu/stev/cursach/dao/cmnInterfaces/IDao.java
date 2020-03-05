package edu.stev.cursach.dao.cmnInterfaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {
    MongoRepository getRepository();

    default T save (T element){//create
        return (T) getRepository().save(element);
    }
    default T get(String id){
        System.out.println("get from IDao");
        T obj = (T) getRepository().findById(id);
        return (T) ((Optional<T>)getRepository().findById(id)).orElse(null);
    } //read
    default List<T> getAll(){
        return getRepository().findAll();
    }
    default T edit(T element){
        return null;
    } //update
    default void delete(String id){
        getRepository().deleteById(id);
    } //delete
}

