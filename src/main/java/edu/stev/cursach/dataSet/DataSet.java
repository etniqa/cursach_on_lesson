package edu.stev.cursach.dataSet;

import edu.stev.cursach.model.Group;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class DataSet {
    Group first = new Group(UUID.randomUUID().toString(), "243", "good boys and girls", LocalDateTime.now(), null);
    Group second = new Group(UUID.randomUUID().toString(), "243sk", "good boys", LocalDateTime.now(), null);
    private ArrayList<Group> groups = new ArrayList<>(Arrays.asList(first, second));

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public void setGroup(int index, Group newGroup){
        this.groups.set(index, newGroup);
    }
}
