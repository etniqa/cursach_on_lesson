package edu.stev.cursach.dao.cmnInterfaces;

import edu.stev.cursach.dataSet.cmnInterfaces.IDataSet;
import edu.stev.cursach.dataSet.mainDataSet.DataSet;
import edu.stev.cursach.model.cmnInterfaces.ICommonFields;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
public interface IDao<T> {
    IDataSet getDataSet();

    default T save (T element){

        return getDataSet().getList().add(element) ? element : null;
    } //create
    default T get(String id){ //read
        List<ICommonFields> list = getDataSet().getList();
        return (T) list.stream()
                .filter(element -> element.getId().equals(id)).findFirst().orElse(null);
    }
    default List<T> getAll(){
        return getDataSet().getList();
    }
    default T edit(String id, T newElem){
        return null;
    } //update
    default T delete(String id){
        System.out.println("delete from IDao for "); //+ T.class.getName());
        List<T> list = getDataSet().getList();
        list.remove(get(id));
        return getDataSet().getList().remove(get(id)) ? get(id) : null;
    } //delete
}

