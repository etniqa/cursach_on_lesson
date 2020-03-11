package edu.stev.cursach.controller.web.controllers;

import edu.stev.cursach.service.classes.organization.impls.OrganizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/organization")
public class OrganizationWebController {
    @Autowired
    OrganizationServiceImpl organizationService;

    @RequestMapping("/get/list")
    String getAll(Model model){
        model.addAttribute("organizations", organizationService.getAll());
        return "organizationList";}
    @RequestMapping("/delete/{id}")
    String delete(@PathVariable("id") String id) {
        organizationService.delete(id);
        return "redirect:/web/organization/get/list";
    }
}
