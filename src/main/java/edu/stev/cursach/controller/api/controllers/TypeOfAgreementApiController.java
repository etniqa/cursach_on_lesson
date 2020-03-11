package edu.stev.cursach.controller.api.controllers;

import edu.stev.cursach.controller.api.interfaces.ICommonApiController;
import edu.stev.cursach.model.TypeOfAgreement;
import edu.stev.cursach.service.classes.typeOfAgreement.impls.TypeOfAgreementServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/type_of_agreement")
public class TypeOfAgreementApiController implements ICommonApiController<TypeOfAgreement> {
    @Autowired
    TypeOfAgreementServiceImpl typeOfAgreementService;

    @Override
    public IService getService() {
        return this.typeOfAgreementService;
    }
}
