package edu.stev.cursach.controller.web;

import edu.stev.cursach.service.classes.typeOfAgreement.impls.TypeOfAgreementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}