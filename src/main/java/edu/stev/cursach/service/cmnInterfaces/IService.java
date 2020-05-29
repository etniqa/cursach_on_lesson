package edu.stev.cursach.service.cmnInterfaces;

import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.cmnInterfaces.ICommonFields;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//declaration 5 methods of CRUD
public interface IService<T extends ICommonFields> {
    Logger getLogger();
    IDao getDao();

    default T save(T element){
        element.setCreationDate(LocalDateTime.now());
        getLogger().setLevel(Level.ALL);
        getLogger().logp(Level.FINE, this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1),
                Thread.currentThread().getStackTrace()[1].getMethodName(), "saving...");
        return (T) getDao().save(element);
    } //create
    default T edit(T element){
        System.out.println("edit in IService for " + element.getClass().toString());
        element.setDateModified(LocalDateTime.now());
        getLogger().setLevel(Level.ALL);
        getLogger().logp(Level.FINE, this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1),
                Thread.currentThread().getStackTrace()[1].getMethodName(), "editing...");
        return (T) getDao().edit(element);
    }
    default T getById(String id){
        getLogger().setLevel(Level.ALL);
        getLogger().logp(Level.FINE, this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1),
                Thread.currentThread().getStackTrace()[1].getMethodName(), "getting by id...");
        return (T) getDao().getById(id);
    } //read
    default List<T> getAll(){
        getLogger().setLevel(Level.ALL);
        getLogger().logp(Level.FINE, this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1),
                Thread.currentThread().getStackTrace()[1].getMethodName(), "getting...");
        return getDao().getAll();
    } //update
    default void delete(String id){ //delete
        getLogger().setLevel(Level.ALL);
        getLogger().logp(Level.FINE, this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1),
                Thread.currentThread().getStackTrace()[1].getMethodName(), "deleting...");
        getDao().delete(id);
    }

    default <T extends ICommonFields> List<T> getAllSortedByName() {
        List<T> sorted = this.getDao().getAll();
        sorted.sort(new MyComparatorByName<>());
        return sorted;
    }

    default <T extends ICommonFields> List<T> getAllSortedByDate() {
        List<T> sorted = this.getDao().getAll();
        sorted.sort(new MyComparatorByDate<>());
        return sorted;
    }


    class MyComparatorByDate<T extends ICommonFields> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            return o1.getCreationDate().compareTo(o2.getCreationDate());
        }
    }

    class MyComparatorByName<T extends ICommonFields> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
        }
    }
}
