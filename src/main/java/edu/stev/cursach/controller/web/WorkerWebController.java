package edu.stev.cursach.controller.web;

import edu.stev.cursach.form.WorkerForm;
import edu.stev.cursach.model.pojos.*;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.classes.department.impls.DepartmentServiceImpl;
import edu.stev.cursach.service.classes.equipment.impls.EquipmentServiceImpls;
import edu.stev.cursach.service.classes.organization.impls.OrganizationServiceImpl;
import edu.stev.cursach.service.classes.technicianHasEquipment.impls.TechnicianHasEquipmentServiceImpl;
import edu.stev.cursach.service.classes.typeOfAgreement.impls.TypeOfAgreementServiceImpl;
import edu.stev.cursach.service.classes.worker.impls.WorkerServiceImpl;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("/web/worker")
public class WorkerWebController {
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
        model.addAttribute("Assistant", Assistant.class);
        model.addAttribute("Designer", Designer.class);
        model.addAttribute("Engineer", Engineer.class);
        model.addAttribute("Staff", Staff.class);
        model.addAttribute("Technician", Technician.class);
        model.addAttribute("workers", workerService.getAll());
        return "workerList";
    }
    @RequestMapping("/delete/{id}")
    String delete(@PathVariable("id") String id) {
        System.out.println("here");
        workerService.delete(id);
        return "redirect:/web/worker/get/list";
    }

    @RequestMapping(value = "/add/{typeOfWorker}", method = RequestMethod.GET)
    String add(@PathVariable("typeOfWorker") String typeOfWorker, Model model){
        model.addAttribute("typeOfWorker", typeOfWorker);
        WorkerForm workerForm = new WorkerForm();
        model.addAttribute("workerForm", workerForm);
        Map<String, String> departmentsMap = departmentService.getAll().stream()
                .collect(Collectors.toMap(Department::getId, Department::getName));
        model.addAttribute("departmentsMap", departmentsMap);
        Map<String, String> agreementsMap = typeOfAgreementService.getAll().stream()
                .collect(Collectors.toMap(TypeOfAgreement::getId, TypeOfAgreement::getFullName));
        model.addAttribute("agreementsMap", agreementsMap);
        return "workerAdd";
    }

    //for post filled form for some bean to add
    @RequestMapping(value = "/add/{typeOfWorker}", method = RequestMethod.POST)
    String add(@PathVariable("typeOfWorker") String typeOfWorker, @ModelAttribute("workerForm") WorkerForm workerForm) {
        Worker worker = new Worker(
                null,
                workerForm.getName(),
                workerForm.getDescription(),
                LocalDateTime.now(),
                null,
                departmentService.getById(workerForm.getDepartmentWhereWorksId()),
                typeOfAgreementService.getById(workerForm.getAgreementWhereIsWorkingId())
        );
        switch (typeOfWorker){
            case "assistant": {
                Assistant newWorker = new Assistant();
                BeanUtils.copyProperties(worker, newWorker);
                newWorker.setRate(workerForm.getAdditionalField());
                workerService.save(newWorker);
                break;
            }
            case "designer": {
                Designer newWorker = new Designer();
                BeanUtils.copyProperties(worker, newWorker);
                newWorker.setNumberOfLicences(workerForm.getAdditionalField());
                workerService.save(newWorker);
                break;
            }
            case "engineer": {
                Engineer newWorker = new Engineer();
                BeanUtils.copyProperties(worker, newWorker);
                newWorker.setYearsOfExperience(workerForm.getAdditionalField());
                workerService.save(newWorker);
                break;
            }
            case "staff": {
                Staff newWorker = new Staff();
                BeanUtils.copyProperties(worker, newWorker);
                newWorker.setRang(workerForm.getAdditionalField());
                workerService.save(newWorker);
                break;
            }
            case "technician": {
                Technician newWorker  = new Technician();
                BeanUtils.copyProperties(worker, newWorker);
                newWorker.setYearsOfExperience(workerForm.getAdditionalField());
                workerService.save(newWorker);
                break;
            }
        }
        return "redirect:/web/worker/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Worker workerWhichEdit = workerService.getById(id);
        WorkerForm workerForm = new WorkerForm(
                workerWhichEdit.getName(),
                workerWhichEdit.getDescription(),
                workerWhichEdit.getDepartmentWhereWorks().getId(),
                workerWhichEdit.getAgreementWhereIsWorking().getId(),
                0
        );
        switch (workerWhichEdit.getShortClassName().toLowerCase()){
            case "assistant":{
                workerForm.setAdditionalField(((Assistant)workerService.getById(id)).getRate());
                break;
            }
            case "designer":{
                workerForm.setAdditionalField(((Designer)workerService.getById(id)).getNumberOfLicences());
                break;
            }
            case "engineer":{
                workerForm.setAdditionalField(((Engineer)workerService.getById(id)).getYearsOfExperience());
                break;
            }
            case "staff":{
                workerForm.setAdditionalField(((Staff)workerService.getById(id)).getRang());
                break;
            }
            case "technician":{
                workerForm.setAdditionalField(((Technician)workerService.getById(id)).getYearsOfExperience());
                break;
            }
        }
        model.addAttribute("workerForm", workerForm);
        model.addAttribute("typeOfWorker", workerWhichEdit.getShortClassName().toLowerCase());

        Map<String, String> departmentsMap = departmentService.getAll().stream()
                .collect(Collectors.toMap(Department::getId, Department::getName));
        model.addAttribute("departmentsMap", departmentsMap);
        Map<String, String> agreementsMap = typeOfAgreementService.getAll().stream()
                .collect(Collectors.toMap(TypeOfAgreement::getId, TypeOfAgreement::getFullName));
        model.addAttribute("agreementsMap", agreementsMap);
        return "workerAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("workerForm") WorkerForm workerForm) {
        Worker workerWhichEditWithCmnFieldsOnly = workerService.getById(id);
        workerWhichEditWithCmnFieldsOnly = new Worker(
                workerWhichEditWithCmnFieldsOnly.getId(),
                workerForm.getName(),
                workerForm.getDescription(),
                workerWhichEditWithCmnFieldsOnly.getCreationDate(),
                LocalDateTime.now(),
                departmentService.getById(workerForm.getDepartmentWhereWorksId()),
                typeOfAgreementService.getById(workerForm.getAgreementWhereIsWorkingId())
        );

        switch (workerService.getById(id).getShortClassName().toLowerCase()){
            case "assistant":{
                Assistant workerWhichEdit = new Assistant();
                BeanUtils.copyProperties(workerWhichEditWithCmnFieldsOnly, workerWhichEdit);
                workerWhichEdit.setRate(workerForm.getAdditionalField());
                workerService.edit(workerWhichEdit);
                break;
            }
            case "designer":{
                Designer workerWhichEdit = new Designer();
                BeanUtils.copyProperties(workerWhichEditWithCmnFieldsOnly, workerWhichEdit);
                workerWhichEdit.setNumberOfLicences(workerForm.getAdditionalField());
                workerService.edit(workerWhichEdit);
                break;
            }
            case "engineer":{
                Engineer workerWhichEdit = new Engineer();
                BeanUtils.copyProperties(workerWhichEditWithCmnFieldsOnly, workerWhichEdit);
                workerWhichEdit.setYearsOfExperience(workerForm.getAdditionalField());
                workerService.edit(workerWhichEdit);
                break;
            }
            case "staff":{
                Staff workerWhichEdit = new Staff();
                BeanUtils.copyProperties(workerWhichEditWithCmnFieldsOnly, workerWhichEdit);
                workerWhichEdit.setRang(workerForm.getAdditionalField());
                workerService.edit(workerWhichEdit);
                break;
            }
            case "technician":{
                Technician workerWhichEdit = new Technician();
                BeanUtils.copyProperties(workerWhichEditWithCmnFieldsOnly, workerWhichEdit);
                workerWhichEdit.setYearsOfExperience(workerForm.getAdditionalField());
                workerService.edit(workerWhichEdit);
                break;
            }
        }
        return "redirect:/web/worker/get/list";
    }
}
