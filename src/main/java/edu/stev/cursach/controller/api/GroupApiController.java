package edu.stev.cursach.controller.api;

import edu.stev.cursach.model.Group;
import edu.stev.cursach.service.group.impls.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/group")
public class GroupApiController {
    @Autowired
    private GroupServiceImpl groupService;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    List<Group> getAll(){
        return groupService.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    Group getGroup(@PathVariable("id") String id) {
        System.out.println("here");
        return groupService.get(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    Group addGroup(@RequestBody Group group){
        return groupService.save(group);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    void deleteGroup(@PathVariable("id") String id) {
        groupService.delete(id);
        this.getAll();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    Group editGroup(@PathVariable("id") String id, @RequestBody Group group){
        return this.groupService.edit(group);
    }
}
