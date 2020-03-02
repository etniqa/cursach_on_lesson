package edu.stev.cursach.service.group.impls;

import edu.stev.cursach.dao.group.impls.GroupDaoImplFake;
import edu.stev.cursach.dao.group.repository.GroupRepository;
import edu.stev.cursach.model.Group;
import edu.stev.cursach.service.group.interfaces.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
@Service
public class GroupServiceImpl implements IGroupService {
    @Autowired
    GroupDaoImplFake dao;

    @Override
    public Object save(Object element) {
        return null;
    }

    @Override
    public Object edit(Object element) {
        return null;
    }

    @Override
    public Group get(String id) {
        return this.dao.get(id);
    }

    @Override
    public List<Group> getAll() {
        return dao.getAll();
    }

    @Override
    public boolean delete(String id) {
        //TODO implement method
        return this.dao.delete(id);
    }

}
