package edu.stev.cursach.dao.group.impls;

import edu.stev.cursach.dao.group.interfaces.IGroupDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
@Component
public class GroupDaoImplFake implements IGroupDao {
    @Autowired
    DataSet dataSet;

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
        return this.dataSet.getGroups();
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
