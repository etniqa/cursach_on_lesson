package edu.stev.cursach.controller.api.cmnInterface;

import edu.stev.cursach.model.cmnInterfaces.ICommonFields;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface ICommonApiController<T extends ICommonFields> {

    Logger getLogger();
    IService getService();

    @RequestMapping(value = "/search_by_name/{partOfName}", method = RequestMethod.GET)
    default List<T> searchByName(@PathVariable("partOfName") String partOfName){
        getLogger().setLevel(Level.ALL);
        getLogger().logp(Level.FINE, this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1),
                Thread.currentThread().getStackTrace()[1].getMethodName(), "searchin by name...");
        return getService().searchByName(partOfName);
    }

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    default List<T> getAll(){
        getLogger().setLevel(Level.ALL);
        getLogger().logp(Level.FINE, this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1),
                Thread.currentThread().getStackTrace()[1].getMethodName(), "getting...");
        return getService().getAll();
    }

    @RequestMapping(value = "/get/list/sorted_by_name", method = RequestMethod.GET)
    default List<T> getAllSortedByName(){
        getLogger().setLevel(Level.ALL);
        getLogger().logp(Level.FINE, this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1),
                Thread.currentThread().getStackTrace()[1].getMethodName(), "getting all sorted by name...");
        return getService().getAllSortedByName();
    }

    @RequestMapping(value = "/get/list/sorted_by_creation_date", method = RequestMethod.GET)
    default List<T> getAllSortedByCreationDate(){
        getLogger().setLevel(Level.ALL);
        getLogger().logp(Level.FINE, this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1),
                Thread.currentThread().getStackTrace()[1].getMethodName(), "getting all sorted by creation date...");
        return getService().getAllSortedByDate();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    default T addObject(@RequestBody T object){
        getLogger().setLevel(Level.ALL);
        getLogger().logp(Level.FINE, this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1),
                Thread.currentThread().getStackTrace()[1].getMethodName(), "adding...");
        return (T) getService().save(object);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    default T editObject(@RequestBody T object){
        getLogger().setLevel(Level.ALL);
        getLogger().logp(Level.FINE, this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1),
                Thread.currentThread().getStackTrace()[1].getMethodName(), "editing...");
        return (T) getService().edit(object);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    default T getObjectById(@PathVariable("id") String id){
        getLogger().setLevel(Level.ALL);
        getLogger().logp(Level.FINE, this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1),
                Thread.currentThread().getStackTrace()[1].getMethodName(), "getting by id...");
        getLogger().log(Level.INFO, id);
        return (T) getService().getById(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    default List<T> deleteObject(@PathVariable("id") String id) {
        getLogger().setLevel(Level.ALL);
        getLogger().logp(Level.FINE, this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1),
                Thread.currentThread().getStackTrace()[1].getMethodName(), "deleting...");
        getService().delete(id);
        return this.getAll();
    }
}
