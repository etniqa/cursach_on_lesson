package edu.stev.cursach.controller.web;

import edu.stev.cursach.form.TechnicianHasEquipmentForm;
import edu.stev.cursach.form.TypeOfAgreementForm;
import edu.stev.cursach.model.pojos.*;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.classes.department.impls.DepartmentServiceImpl;
import edu.stev.cursach.service.classes.equipment.impls.EquipmentServiceImpls;
import edu.stev.cursach.service.classes.organization.impls.OrganizationServiceImpl;
import edu.stev.cursach.service.classes.technicianHasEquipment.impls.TechnicianHasEquipmentServiceImpl;
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
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/type_of_agreement")
public class TypeOfAgreementWebController {
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
    @Autowired
    TechnicianHasEquipmentServiceImpl technicianHasEquipmentService;

    @RequestMapping("/get/list")
    String getAll(Model model){
        model.addAttribute("typeOfAgreements", typeOfAgreementService.getAll());
        return "typeOfAgreementList";
    }
    @RequestMapping("/delete/{id}")
    String delete(@PathVariable("id") String id) {
        typeOfAgreementService.delete(id);
        return "redirect:/web/type_of_agreement/get/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    String add(Model model) {
        TypeOfAgreementForm typeOfAgreementForm = new TypeOfAgreementForm();
        model.addAttribute("typeOfAgreementForm", typeOfAgreementForm);
        Map<String, String> organizationsMap = this.organizationService.getAll().stream()
                .collect(Collectors.toMap(Organization::getId, Organization::getName));
        model.addAttribute("organizationsMap", organizationsMap);
        Map<String, String> twoTypesMap = new LinkedHashMap<>();
        twoTypesMap.put("contract", "contract");
        twoTypesMap.put("project", "project");
        model.addAttribute("twoTypesMap", twoTypesMap);
        model.addAttribute("isShowTwoTypes", true);
        return "typeOfAgreementAdd";
    }

    //for post filled form for some bean to add
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    String add(@ModelAttribute("typeOfAgreementForm") TypeOfAgreementForm typeOfAgreementForm) {
        TypeOfAgreement newTypeOfAgreement;
        if(typeOfAgreementForm.getType() == "contract"){
            newTypeOfAgreement = new Contract(
                    null,
                    typeOfAgreementForm.getName(),
                    typeOfAgreementForm.getDescription(),
                    LocalDateTime.now(),
                    null,
                    typeOfAgreementForm.getBegDateParsed(),
                    typeOfAgreementForm.getEndDateParsed(),
                    organizationService.get(typeOfAgreementForm.getOrganizationWhichSignId()),
                    typeOfAgreementForm.getCost()
        );
        } else {
            newTypeOfAgreement = new Project(
                    null,
                    typeOfAgreementForm.getName(),
                    typeOfAgreementForm.getDescription(),
                    LocalDateTime.now(),
                    null,
                    typeOfAgreementForm.getBegDateParsed(),
                    typeOfAgreementForm.getEndDateParsed(),
                    organizationService.get(typeOfAgreementForm.getOrganizationWhichSignId()),
                    typeOfAgreementForm.getCost()
            );
        }
        typeOfAgreementService.save(newTypeOfAgreement);
        return "redirect:/web/type_of_agreement/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        TypeOfAgreement typeOfAgreementWhichEdit = typeOfAgreementService.get(id);
        TypeOfAgreementForm typeOfAgreementForm = new TypeOfAgreementForm(
                typeOfAgreementWhichEdit.getName(),
                typeOfAgreementWhichEdit.getDescription(),
                typeOfAgreementWhichEdit.getDateBeg() == null ? "" : typeOfAgreementWhichEdit.getDateBeg().toString(),
                typeOfAgreementWhichEdit.getDateEnd() == null ? "" : typeOfAgreementWhichEdit.getDateEnd().toString(),
                typeOfAgreementWhichEdit.getOrganizationWhichSign().getId(),
                typeOfAgreementWhichEdit.getCost()
        );
        model.addAttribute("typeOfAgreementForm", typeOfAgreementForm);
        Map<String, String> organizationsMap = this.organizationService.getAll().stream()
                .collect(Collectors.toMap(Organization::getId, Organization::getName));
        model.addAttribute("organizationsMap", organizationsMap);
        model.addAttribute("isShowTwoTypes", false);
        return "typeOfAgreementAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("typeOfAgreementForm") TypeOfAgreementForm typeOfAgreementForm) {
        TypeOfAgreement newTypeOfAgreement = new TypeOfAgreement(
                null,
                typeOfAgreementForm.getName(),
                typeOfAgreementForm.getDescription(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                typeOfAgreementForm.getBegDateParsed(),
                typeOfAgreementForm.getEndDateParsed(),
                organizationService.get(typeOfAgreementForm.getOrganizationWhichSignId()),
                typeOfAgreementForm.getCost()
        );
        typeOfAgreementService.edit(newTypeOfAgreement);
        return "redirect:/web/type_of_agreement/get/list";
    }
}
