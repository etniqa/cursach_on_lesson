package edu.stev.cursach.service.group.interfaces;

import edu.stev.cursach.dao.group.impls.GroupDaoImplFake;
import edu.stev.cursach.model.Group;
import edu.stev.cursach.service.group.impls.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupServiceImpl implements IGroupService {
    @Autowired
    GroupDaoImplFake dao;

    @Override
    public Group save(Group group) {
        return null;
    }

    @Override
    public Group get(String is) {
        return null;
    }

    @Override
    public List<Group> getAll() {
        return dao.getAll()  ;
    }

    @Override
    public Group edit(Group group) {
        return null;
    }

    @Override
    public Group delete(Group group) {
        return null;
    }
}
