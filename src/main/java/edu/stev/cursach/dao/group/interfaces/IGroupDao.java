package edu.stev.cursach.dao.group.interfaces;

import edu.stev.cursach.model.Group;

import java.util.List;

public interface IGroupDao {
    Group save (Group group); //create
    Group get(String id); //read
    List<Group> getAll();
    Group edit(Group group); //update
    boolean delete(String id); //delete
}
