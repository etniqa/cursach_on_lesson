package edu.stev.cursach.controller.web;

import edu.stev.cursach.model.Group;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {
    private List<Group> groups = Arrays.asList(
            new Group("1", "Baranov S.", "good boy", LocalDateTime.now(), null),
            new Group("2", "Gubya M.", "pretty boy", LocalDateTime.now(), null)
    );
    @RequestMapping("/list")
    List<Group> getAll(){
        return groups;
    }
}
