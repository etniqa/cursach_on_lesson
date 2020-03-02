package edu.stev.cursach.controller.api;

import edu.stev.cursach.model.Organization;
import edu.stev.cursach.service.classes.organization.impls.OrganizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/organization")
public class OrganizationApiController {
    @Autowired
    OrganizationServiceImpl organizationService;

    @RequestMapping("/list")
    List<Organization> getAll(){return this.organizationService.getAll();}
}
