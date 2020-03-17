package edu.stev.cursach.controller.web;

import edu.stev.cursach.form.LogHeadOfDepartmentForm;
import edu.stev.cursach.form.OrganizationForm;
import edu.stev.cursach.model.pojos.*;
import edu.stev.cursach.service.classes.organization.impls.OrganizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
import java.util.stream.Collectors;

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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    String add(Model model) {
        OrganizationForm organizationForm = new OrganizationForm();
        model.addAttribute("organizationForm", organizationForm);
        Map<String, String> headOrganizationsMap = organizationService.getAll().stream()
            .collect(Collectors.toMap(Organization::getId, Organization::getName));
        model.addAttribute("headOrganizationsMap", headOrganizationsMap);
        return "organizationAdd";
    }

    //for post filled form for some bean to add
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    String add(@ModelAttribute("organizationForm") OrganizationForm organizationForm) {
        Organization newOrganization = new Organization(null,
                organizationForm.getName(),
                organizationForm.getDescription(),
                null, null,
                organizationService.get(organizationForm.getHeadOrganizationId()));
        organizationService.save(newOrganization);
        return "redirect:/web/organization/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Organization organizationWhichEdit = organizationService.get(id);
        OrganizationForm organizationForm = new OrganizationForm(
                organizationWhichEdit.getName(),
                organizationWhichEdit.getDescription(),
                organizationWhichEdit.getHeadOrganization() == null ? "null" : organizationWhichEdit.getHeadOrganization().getId());
        model.addAttribute("organizationForm", organizationForm);
        Map<String, String> headOrganizationsMap = organizationService.getAll().stream()
                .collect(Collectors.toMap(Organization::getId, Organization::getName));
        model.addAttribute("headOrganizationsMap", headOrganizationsMap);
        return "organizationAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("organizationForm") OrganizationForm organizationForm) {
        Organization organizationWhichEdit = organizationService.get(id);
        organizationWhichEdit = new Organization(
                id,
                organizationForm.getName(),
                organizationForm.getDescription(),
                organizationWhichEdit.getCreationDate(), null,
                organizationService.get(organizationForm.getHeadOrganizationId()));
        organizationService.edit(organizationWhichEdit);
        return "redirect:/web/organization/get/list";
    }
}
