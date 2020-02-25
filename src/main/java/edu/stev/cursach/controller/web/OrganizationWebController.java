package edu.stev.cursach.controller.web;

import edu.stev.cursach.model.Organization;
import edu.stev.cursach.service.organization.impls.OrganizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/web/organization")
public class OrganizationWebController {
    @Autowired
    OrganizationServiceImpl organizationService;

    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("organizations", organizationService.getAll());
        return "organizationList";}
}
