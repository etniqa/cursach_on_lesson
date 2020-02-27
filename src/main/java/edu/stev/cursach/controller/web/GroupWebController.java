package edu.stev.cursach.controller.web;

import edu.stev.cursach.model.Group;
import edu.stev.cursach.service.group.impls.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//always return string
@Controller
@RequestMapping("/web/group")
public class GroupWebController {
    @Autowired
    private GroupServiceImpl groupService;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(Model model){
        model.addAttribute("groups", groupService.getAll()); //groups is the same in
        return "groupList"; //string is the same should be groupList.ftl
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String delete(Model model, @PathVariable("id") String id) {
        groupService.delete(id);
        return "redirect:/web/group/list";
    }


}
