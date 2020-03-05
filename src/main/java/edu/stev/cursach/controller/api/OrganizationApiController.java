package edu.stev.cursach.controller.api;

import edu.stev.cursach.model.Organization;
import edu.stev.cursach.service.classes.organization.impls.OrganizationServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/organization")
public class OrganizationApiController implements ICommonApiController<Organization>{
    @Autowired
    OrganizationServiceImpl organizationService;

    @Override
    public IService getService() {
        return this.organizationService;
    }
}
