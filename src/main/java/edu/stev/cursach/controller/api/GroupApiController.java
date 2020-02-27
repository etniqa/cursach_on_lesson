package edu.stev.cursach.controller.api;

import edu.stev.cursach.model.Group;
import edu.stev.cursach.service.group.impls.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/group")
public class GroupApiController {
    @Autowired
    private GroupServiceImpl groupService;

    //value = link where function will work
    //method = http request< when function will be work
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    List<Group> getAll(){
        System.out.println("here");
        return groupService.getAll();
    }

    //can send here JSON-class from postman
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    void addGroup(@RequestBody Group group){
        System.out.println("catch object from JSON");
        group.setId(UUID.randomUUID().toString());
        groupService.save(group);
    }

    //it says that I have link with /api/group/{id} which reference to this function (make from postman
    // and get function)
    //EXMPL
    //localhost:8080/api/group/4646c458-f2c1-47b4-b0de-48b91e563ba6
    //it shows by JSON your element
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    Group getGroupById(@PathVariable("id") UUID id){
        return groupService.get(id.toString());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    String deleteGroup(@PathVariable("id") String id) {
        groupService.delete(id);
        return "redirect:/api/group/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    void editGroup(@PathVariable("id") String id, @RequestBody Group group){
        this.groupService.edit(id, group);
    }
}
