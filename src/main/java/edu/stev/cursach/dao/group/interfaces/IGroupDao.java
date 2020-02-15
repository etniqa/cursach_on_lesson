package edu.stev.cursach.dao.group.interfaces;

import edu.stev.cursach.model.Group;

import java.util.List;

public interface IGroupDao {
    Group save (Group group); //create
    Group get(String is); //read
    List<Group> getAll();
    Group edit(Group group); //update
    Group delete(Group group); //delete
}
