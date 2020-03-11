package edu.stev.cursach.controller.api.cmnInterface;

import edu.stev.cursach.model.cmnInterfaces.ICommonFields;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface ICommonApiController<T extends ICommonFields> {
    IService getService();

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    default List<T> getAll(){
        return getService().getAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    default void addObject(@RequestBody T object){
        System.out.println("catch object from JSON");
        getService().save(object);
        this.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    default T getObjectById(@PathVariable("id") String id){
        return (T) getService().get(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    default void deleteObject(@PathVariable("id") String id) {
        getService().delete(id);
        this.getAll();
    }
}
