package edu.stev.cursach.service.group.impls;

import java.util.List;

//declaration 5 meths of CRUD
public interface IGroupService {
    Group save (Group group); //create
    Group get(String is); //read
    List<Group> getAll();
    Group edit(Group group); //update
    Group delete(Group group); //delete
}
