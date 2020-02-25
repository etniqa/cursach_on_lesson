package edu.stev.cursach.controller.web;

import edu.stev.cursach.service.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/agreement_has_agreement")
public class AgreementHasAgreementWebController {
    @Autowired
    AgreementHasAgreementServiceImpl agreementBelongToAgreementService;
    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("agreementBelongToAgreements", agreementBelongToAgreementService.getAll());
        return "agreementHasAgreementList";
    }
}
