package edu.stev.cursach.dao.cmnInterfaces;

import edu.stev.cursach.dataSet.DataSet;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
public interface IDao<T> {
    @Autowired
    DataSet dataSet = null;
    T save (T element); //create
    T get(String id);//read
//    default T get(String id){ //read
//        return this.dataSet.getAgreementHasAgreementList().stream()
//                .filter(element -> element.getId().equals(id)).findFirst().orElse(null);
//    }
    List<T> getAll();
    T edit(String id, T newElem); //update
    T delete(String id); //delete
}

