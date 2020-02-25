package edu.stev.cursach.controller.web;

import edu.stev.cursach.model.Group;
import edu.stev.cursach.service.group.impls.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//always return string
@Controller
@RequestMapping("/web/group")
public class GroupWebController {
    @Autowired
    private GroupServiceImpl groupService;
    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("groups", groupService.getAll()); //groups is the same in
        return "groupList"; //string is the same should be groupList.ftl
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        groupService.delete(id);
        model.addAttribute("groups", groupService.getAll());
        return "groupList";
    }
}
