package edu.stev.cursach.controller.api.interfaces;

import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface ICommonApiController<T> {
    IService getService();

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    default List<T> getAll(){
        return getService().getAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    default void addGroup(@RequestBody T element){
        System.out.println("catch object from JSON");
        getService().save(element);
        this.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    default T getGroupById(@PathVariable("id") String id){
        return (T) getService().get(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    default void deleteGroup(@PathVariable("id") String id) {
        getService().delete(id);
        this.getAll();
    }
}
