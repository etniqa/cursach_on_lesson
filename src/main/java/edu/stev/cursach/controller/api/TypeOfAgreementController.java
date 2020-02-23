package edu.stev.cursach.controller.api;

import edu.stev.cursach.model.TypeOfAgreement;
import edu.stev.cursach.service.typeOfAgreement.impls.TypeOfAgreementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/type_of_agreement")
public class TypeOfAgreementController {
    @Autowired
    TypeOfAgreementServiceImpl typeOfAgreementService;

    @RequestMapping("/list")
    public List<TypeOfAgreement> getAll(){
        return this.typeOfAgreementService.getAll();
    }
}
