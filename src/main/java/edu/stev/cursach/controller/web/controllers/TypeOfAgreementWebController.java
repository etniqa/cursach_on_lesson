package edu.stev.cursach.controller.web.controllers;

import edu.stev.cursach.service.classes.typeOfAgreement.impls.TypeOfAgreementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/type_of_agreement")
public class TypeOfAgreementWebController {
    @Autowired
    TypeOfAgreementServiceImpl typeOfAgreementService;

    @RequestMapping("/get/list")
    String getAll(Model model){
        model.addAttribute("typeOfAgreements", typeOfAgreementService.getAll());
        return "typeOfAgreement";
    }
    @RequestMapping("/delete/{id}")
    String delete(@PathVariable("id") String id) {
        typeOfAgreementService.delete(id);
        return "redirect:/web/type_of_agreement/get/list";
    }
}
