package edu.stev.cursach.controller.api;

import edu.stev.cursach.model.AgreementHasAgreement;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
