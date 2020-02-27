package edu.stev.cursach.dao.group.interfaces;

import edu.stev.cursach.model.Group;

import java.util.List;
import java.util.Optional;

public interface IGroupDao {
    Group save (Group group); //create
    Group get(String id); //read
    List<Group> getAll();
    int edit(String id, Group group); //update
    int delete(String id); //delete
}
