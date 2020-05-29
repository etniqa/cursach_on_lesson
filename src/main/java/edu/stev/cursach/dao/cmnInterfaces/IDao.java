package edu.stev.cursach.dao.cmnInterfaces;

import edu.stev.cursach.model.cmnInterfaces.ICommonFields;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface IDao<T extends ICommonFields> {
    Logger getLogger();
    MongoRepository getRepository();

    default T save (T element){//create
        getLogger().setLevel(Level.ALL);
        getLogger().logp(Level.FINE, this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1),
                Thread.currentThread().getStackTrace()[1].getMethodName(), "saving...");
        return (T) getRepository().save(element);
    }
    default T getById(String id){
        getLogger().setLevel(Level.ALL);
        getLogger().logp(Level.FINE, this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1),
                Thread.currentThread().getStackTrace()[1].getMethodName(), "getting by id...");
        T obj = (T) getRepository().findById(id).orElse(null);
        return ((Optional<T>)getRepository().findById(id)).orElse(null);
    } //read
    default List<T> getAll(){
        T obf = null;
        getLogger().setLevel(Level.ALL);
        getLogger().logp(Level.FINE, this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1),
                Thread.currentThread().getStackTrace()[1].getMethodName(), "getting...");
        return getRepository().findAll();
    }
    default T edit(T element){ //update
        getLogger().setLevel(Level.ALL);
        getLogger().logp(Level.FINE, this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1),
                Thread.currentThread().getStackTrace()[1].getMethodName(), "editing...");
        return (T) getRepository().save(element);
    }
    default ICommonFields delete(String id){
        getLogger().setLevel(Level.ALL);
        getLogger().logp(Level.FINE, this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1),
                Thread.currentThread().getStackTrace()[1].getMethodName(), "deleting...");
        ICommonFields objWhichDelete = (ICommonFields) this.getRepository().findById(id).orElse(null);
        getRepository().deleteById(id);
        return objWhichDelete;
    } //delete
}

