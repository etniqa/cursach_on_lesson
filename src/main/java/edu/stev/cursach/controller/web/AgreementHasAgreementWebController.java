package edu.stev.cursach.controller.web;

import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/agreement_has_agreement")
public class AgreementHasAgreementWebController {
    @Autowired
    AgreementHasAgreementServiceImpl agreementHasAgreementService;
    @RequestMapping("/get/list")
    String getAll(Model model){
        model.addAttribute("agreementBelongToAgreements", agreementHasAgreementService.getAll());
        return "agreementHasAgreementList";
    }

    @RequestMapping("/delete/{id}")
    String delete(@PathVariable("id") String id) {
        agreementHasAgreementService.delete(id);
        return "redirect:/web/agreement_has_agreement/get/list";
    }
}
