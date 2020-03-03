package edu.stev.cursach.dao.group.cmnInterfaces;

import edu.stev.cursach.dataSet.cmnInterfaces.IDataSet;
import edu.stev.cursach.model.Group;

import java.util.List;

public interface IDao<T> {
    IDataSet getDataSet();

    default T save(T element){
         getDataSet().getList().add(element);
         return element;
    }
    default T get(String id){
        List<Group> allGroups = getDataSet().getList();
        T resGroup = (T) allGroups.stream().filter(
                group -> group.getId().equals(id)).findFirst().orElse(null);
        return resGroup;
    }
    default List<T> getAll(){
        return getDataSet().getList();
    }
    default T edit(T element){
        return null;
    }
    default boolean delete(String id){
        T objWhichNeedToDelete = this.get(id);
        List<Group> groups = this.getDataSet().getList();
        return this.getDataSet().getList().remove(objWhichNeedToDelete);
    }

}
