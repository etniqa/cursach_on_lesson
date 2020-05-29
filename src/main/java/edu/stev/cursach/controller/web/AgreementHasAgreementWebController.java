package edu.stev.cursach.controller.web;

import edu.stev.cursach.form.AgreementHasAgreementForm;
import edu.stev.cursach.model.pojos.*;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.classes.department.impls.DepartmentServiceImpl;
import edu.stev.cursach.service.classes.equipment.impls.EquipmentServiceImpls;
import edu.stev.cursach.service.classes.organization.impls.OrganizationServiceImpl;
import edu.stev.cursach.service.classes.typeOfAgreement.impls.TypeOfAgreementServiceImpl;
import edu.stev.cursach.service.classes.worker.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/agreement_has_agreement")
public class AgreementHasAgreementWebController {
    @Autowired
    AgreementHasAgreementServiceImpl agreementHasAgreementService;
    @Autowired
    DepartmentServiceImpl departmentService;
    @Autowired
    EquipmentServiceImpls equipmentService;
    @Autowired
    OrganizationServiceImpl organizationService;
    @Autowired
    TypeOfAgreementServiceImpl typeOfAgreementService;
    @Autowired
    WorkerServiceImpl workerService;


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

    //for create form for some bean to add
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    String add(Model model) {
        AgreementHasAgreementForm agreementHasAgreementForm = new AgreementHasAgreementForm();

        Map<String, String> mapHeadAgreement = typeOfAgreementService.getAll().stream()
                .collect(Collectors.toMap(TypeOfAgreement::getId, TypeOfAgreement::getFullName));
        Map<String, String> mapOtherAgreement = typeOfAgreementService.getAll().stream()
                .collect(Collectors.toMap(TypeOfAgreement::getId, TypeOfAgreement::getFullName));
        model.addAttribute("mapHeadAgreement", mapHeadAgreement);
        model.addAttribute("mapOtherAgreement", mapOtherAgreement);
        model.addAttribute("agreementHasAgreementForm", agreementHasAgreementForm);
        return "agreementHasAgreementAdd";
    }

    //for post filled form for some bean to add
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    String add(@ModelAttribute("agreementHasAgreementForm") AgreementHasAgreementForm agreementHasAgreementForm) {
        AgreementHasAgreement newAgreementHasAgreement = new AgreementHasAgreement();

        newAgreementHasAgreement.setName(agreementHasAgreementForm.getName());
        newAgreementHasAgreement.setDescription(agreementHasAgreementForm.getDescription());
        newAgreementHasAgreement.setHeadAgreement(typeOfAgreementService.getById(agreementHasAgreementForm.getHeadAgreementId()));
        newAgreementHasAgreement.setOtherAgreement(typeOfAgreementService.getById(agreementHasAgreementForm.getOtherAgreementId()));

        agreementHasAgreementService.save(newAgreementHasAgreement);
        return "redirect:/web/agreement_has_agreement/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        AgreementHasAgreement agreementHasAgreementWhichEdit = this.agreementHasAgreementService.getById(id);

        AgreementHasAgreementForm agreementHasAgreementForm = new AgreementHasAgreementForm(agreementHasAgreementWhichEdit.getName(),
                agreementHasAgreementWhichEdit.getDescription(), agreementHasAgreementWhichEdit.getHeadAgreement().getId(),
                agreementHasAgreementWhichEdit.getOtherAgreement().getId());

        Map<String, String> mapAgreements = typeOfAgreementService.getAll().stream()
                .collect(Collectors.toMap(TypeOfAgreement::getId, TypeOfAgreement::getFullName));

        model.addAttribute("mapHeadAgreement", mapAgreements);
        model.addAttribute("mapOtherAgreement", mapAgreements);
        model.addAttribute("agreementHasAgreementForm", agreementHasAgreementForm);
        return "agreementHasAgreementAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("agreementHasAgreementForm") AgreementHasAgreementForm agreementHasAgreementForm) {
        AgreementHasAgreement agreementHasAgreementWhichEdit = agreementHasAgreementService.getById(id);
        agreementHasAgreementWhichEdit = new AgreementHasAgreement(agreementHasAgreementWhichEdit.getId(), agreementHasAgreementForm.getName(),
                agreementHasAgreementForm.getDescription(), agreementHasAgreementWhichEdit.getCreationDate(), LocalDateTime.now(),
                typeOfAgreementService.getById(agreementHasAgreementForm.getHeadAgreementId()), typeOfAgreementService.getById(agreementHasAgreementForm.getOtherAgreementId()));
        agreementHasAgreementService.edit(agreementHasAgreementWhichEdit);
        return "redirect:/web/agreement_has_agreement/get/list";
    }
}
