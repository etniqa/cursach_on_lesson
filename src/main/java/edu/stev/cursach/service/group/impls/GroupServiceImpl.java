package edu.stev.cursach.service.group.impls;

import edu.stev.cursach.dao.group.impls.GroupDaoImplFake;
import edu.stev.cursach.model.Group;
import edu.stev.cursach.service.group.interfaces.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class GroupServiceImpl implements IGroupService {
    @Autowired
    GroupDaoImplFake dao;

    @Override
    public Group save(Group group) {
        group.setCreationDate(LocalDateTime.now());
        group.setDateModified(LocalDateTime.now());
        dao.save(group);
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
    public int edit(String id, Group group) {
        return this.dao.edit(id, group);
    }

    @Override
    public boolean delete(String id) {
        return this.dao.delete(id) > 0;
    }

}
