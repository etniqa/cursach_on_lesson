package edu.stev.cursach.dataSet.generalDataSet;

import edu.stev.cursach.model.Group;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataSet {
    boolean wasInit = false;

    Group first = new Group("1", "243", "good boys and girls", LocalDateTime.now(), null);
    Group second = new Group("2", "243sk", "good boys", LocalDateTime.now(), null);
    private ArrayList<Group> groups = new ArrayList<>(Arrays.asList(first, second));

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }
}
