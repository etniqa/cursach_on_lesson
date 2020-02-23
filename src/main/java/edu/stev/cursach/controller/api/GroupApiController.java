package edu.stev.cursach.controller.api;

import edu.stev.cursach.model.Group;
import edu.stev.cursach.service.group.impls.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupApiController {
    @Autowired
    private GroupServiceImpl groupService;
    @RequestMapping("/list")
    List<Group> getAll(){
        return groupService.getAll();
    }
}
