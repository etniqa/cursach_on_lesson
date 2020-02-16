package edu.stev.cursach.controller.web;

import edu.stev.cursach.model.AgreementBelongToAgreement;
import edu.stev.cursach.service.agreementBelongToAgreement.impls.AgreementBelongToAgreementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/aggreement_belong_to_agreement")
public class AgreementBelongToAgreementController {
    @Autowired
    AgreementBelongToAgreementServiceImpl agreementBelongToAgreementService;
    @RequestMapping("/list")
    List<AgreementBelongToAgreement> getAll(){
        return this.agreementBelongToAgreementService.getAll();
    }

}
