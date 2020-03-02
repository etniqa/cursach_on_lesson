package edu.stev.cursach.controller.api;

import edu.stev.cursach.model.AgreementHasAgreement;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/agreement_has_agreement")
public class AgreementHasAgreementApiController {
    @Autowired
    AgreementHasAgreementServiceImpl agreementBelongToAgreementService;
    @RequestMapping("/list")
    List<AgreementHasAgreement> getAll(){
        return this.agreementBelongToAgreementService.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    AgreementHasAgreement get(@PathVariable("id") String id){
        return agreementBelongToAgreementService.get(id);
    }
}
