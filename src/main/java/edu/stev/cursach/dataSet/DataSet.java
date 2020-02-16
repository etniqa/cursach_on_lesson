package edu.stev.cursach.dataSet;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class DataSet {
    private List<Group> groups = Arrays.asList(
            new Group("1", "Baranov S.", "good boy", LocalDateTime.now(), null),
            new Group("2", "Gubya M.", "pretty boy", LocalDateTime.now(), null)
    );

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
