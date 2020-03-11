package edu.stev.cursach.controller.api.controllers;

import edu.stev.cursach.controller.api.interfaces.ICommonApiController;
import edu.stev.cursach.model.AgreementHasAgreement;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agreement_has_agreement")
public class AgreementHasAgreementApiController implements ICommonApiController<AgreementHasAgreement> {
    @Autowired
    AgreementHasAgreementServiceImpl agreementHasAgreementService;

    @Override
    public IService getService() {
        return this.agreementHasAgreementService;
    }
}
