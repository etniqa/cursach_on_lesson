package edu.stev.cursach.dao.group.impls;

import edu.stev.cursach.dao.group.interfaces.IGroupDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        Group groupWhichNeedToEdit = allGroups.stream().filter(
                group -> group.getId().equals(id)).findFirst().orElse(null);
        return groupWhichNeedToEdit;
    }
    @Override
    public List<Group> getAll() {
        return this.dataSet.getGroups();
    }

    @Override
    public int edit(String id, Group group) {
        int indexOfGroupWhatWeWantToEdit = this.getAll().indexOf(this.get(id));
        if (indexOfGroupWhatWeWantToEdit >= 0){
            this.dataSet.setGroup(indexOfGroupWhatWeWantToEdit, group);
        } else {
            return 0;
        }
        return 1;
    }

    @Override
    public int delete(String id) {
        Group groupWhichNeedToDelete = this.get(id);
        List<Group> groups = this.dataSet.getGroups();
        return this.dataSet.getGroups().remove(groupWhichNeedToDelete) ? 1 : 0;
    }
}
