package edu.stev.cursach.controller.web.controllers;

import edu.stev.cursach.form.AgreementHasAgreementForForm;
import edu.stev.cursach.model.pojos.AgreementHasAgreement;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/web/agreement_has_agreement")
public class AgreementHasAgreementWebController {
    @Autowired
    AgreementHasAgreementServiceImpl agreementHasAgreementService;
    @RequestMapping("/get/list")
    String getAll(Model model){
        model.addAttribute("agreementHasAgreements", agreementHasAgreementService.getAll());
        return "agreementHasAgreementList";
    }

    @RequestMapping("/delete/{id}")
    String delete(@PathVariable("id") String id) {
        agreementHasAgreementService.delete(id);
        return "redirect:/web/agreement_has_agreement/get/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    String create(Model model) {
        AgreementHasAgreementForForm agreementHasAgreementForm = new AgreementHasAgreementForForm();
        model.addAttribute("agreementHasAgreementForm", agreementHasAgreementForm);
        return "agreementHasAgreementAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    String create(@ModelAttribute("agreementHasAgreementForm") AgreementHasAgreementForForm agreementHasAgreementForm) {
        AgreementHasAgreement newAgreementHasAgreement = new AgreementHasAgreement();

        newAgreementHasAgreement.setName(agreementHasAgreementForm.getName());
        newAgreementHasAgreement.setDescription(agreementHasAgreementForm.getDescription());

        agreementHasAgreementService.save(newAgreementHasAgreement);
        return "redirect:/web/agreement_has_agreement/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        AgreementHasAgreement agreementHasAgreementWhichEdit = agreementHasAgreementService.get(id);

        AgreementHasAgreementForForm agreementHasAgreementForm = new AgreementHasAgreementForForm();
        agreementHasAgreementForm.setName(agreementHasAgreementWhichEdit.getName());
        agreementHasAgreementForm.setDescription(agreementHasAgreementWhichEdit.getDescription());

        model.addAttribute("agreementHasAgreementForm", agreementHasAgreementForm);
        return "agreementHasAgreementAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("studentForm") AgreementHasAgreementForForm agreementHasAgreementForm) {
        AgreementHasAgreement newAgreementHasAgreement = new AgreementHasAgreement();
        newAgreementHasAgreement.setId(id);
        newAgreementHasAgreement.setName(agreementHasAgreementForm.getName());
        newAgreementHasAgreement.setDescription(agreementHasAgreementForm.getDescription());
        agreementHasAgreementService.save(newAgreementHasAgreement);
        return "redirect:/web/agreement_has_agreement/get/list";
    }
}
