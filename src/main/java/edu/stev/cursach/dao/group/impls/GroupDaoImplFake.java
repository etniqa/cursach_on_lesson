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
        dataSet.getGroups().add(group);
        return group;
    }
    @Override
    public Group get(String id) {
        List<Group> allGroups = this.dataSet.getGroups();
        Group groupWhichNeedToDelete = allGroups.stream().filter(
                group -> group.getId().equals(id)).findFirst().orElse(null);
        return groupWhichNeedToDelete;
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
    public boolean delete(String id) {
        Group groupWhichNeedToDelete = this.get(id);
        List<Group> groups = this.dataSet.getGroups();
        return this.dataSet.getGroups().remove(groupWhichNeedToDelete);
    }
}
