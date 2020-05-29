package edu.stev.cursach.controller.web;

import edu.stev.cursach.form.LogHeadOfDepartmentForm;
import edu.stev.cursach.model.pojos.*;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.classes.department.impls.DepartmentServiceImpl;
import edu.stev.cursach.service.classes.equipment.impls.EquipmentServiceImpls;
import edu.stev.cursach.service.classes.logHeadOfDepartment.impls.LogHeadOfDepartmentServiceImpl;
import edu.stev.cursach.service.classes.organization.impls.OrganizationServiceImpl;
import edu.stev.cursach.service.classes.typeOfAgreement.impls.TypeOfAgreementServiceImpl;
import edu.stev.cursach.service.classes.worker.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/log_head_of_department")
public class LogHeadOfDepartmentWebController {
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
    LogHeadOfDepartmentServiceImpl logHeadOfDepartmentService;

    @RequestMapping("/get/list")
    String getAll(Model model){
        model.addAttribute("logHeadOfDepartments", logHeadOfDepartmentService.getAll());
        return "logHeadOfDepartmentList";
    }
    @RequestMapping("/delete/{id}")
    String delete(@PathVariable("id") String id) {
        logHeadOfDepartmentService.delete(id);
        return "redirect:/web/log_head_of_department/get/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    String add(Model model) {
        LogHeadOfDepartmentForm logHeadOfDepartmentForm = new LogHeadOfDepartmentForm();
        model.addAttribute("logHeadOfDepartmentForm", logHeadOfDepartmentForm);

        Map<String, String> headsOfDepartmentMap = workerService.getAll().stream()
                .filter(worker -> worker instanceof CanLead)
                .collect(Collectors.toMap(Worker::getId, Worker::getName));
        model.addAttribute("headsOfDepartmentMap", headsOfDepartmentMap);
        Map<String, String> departmentsMap = departmentService.getAll().stream()
                .collect(Collectors.toMap(Department::getId, Department::getName));
        model.addAttribute("departmentsMap", departmentsMap);
        return "logHeadOfDepartmentAddOrEdit";
    }

    //for post filled form for some bean to add
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    String add(@ModelAttribute("logHeadOfDepartmentForm") LogHeadOfDepartmentForm logHeadOfDepartmentForm) {
        LogHeadOfDepartment newLogHeadOfDepartment = new LogHeadOfDepartment(null,
                logHeadOfDepartmentForm.getName(), logHeadOfDepartmentForm.getDescription(),
                null, null, logHeadOfDepartmentForm.getBegDateParsed(),
                logHeadOfDepartmentForm.getEndDateParsed(), (CanLead) workerService.getById(logHeadOfDepartmentForm.getHeadOfDepartmentId()),
                departmentService.getById(logHeadOfDepartmentForm.getDepartmentId()));
        logHeadOfDepartmentService.save(newLogHeadOfDepartment);
        return "redirect:/web/log_head_of_department/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        LogHeadOfDepartment logHeadOfDepartmentWhichEdit = logHeadOfDepartmentService.getById(id);
        LogHeadOfDepartmentForm logHeadOfDepartmentForm = new LogHeadOfDepartmentForm(
                logHeadOfDepartmentWhichEdit.getName(),
                logHeadOfDepartmentWhichEdit.getDescription(),
                logHeadOfDepartmentWhichEdit.getBegDate() == null ? "null" : logHeadOfDepartmentWhichEdit.getBegDate().toString(),
                logHeadOfDepartmentWhichEdit.getEndDate() == null ? "null" : logHeadOfDepartmentWhichEdit.getEndDate().toString(),
                logHeadOfDepartmentWhichEdit.getHeadOfDepartment().getId(),
                logHeadOfDepartmentWhichEdit.getDepartment().getId());
        model.addAttribute("logHeadOfDepartmentForm", logHeadOfDepartmentForm);
        Map<String, String> headsOfDepartmentMap = workerService.getAll().stream()
                .filter(worker -> worker instanceof CanLead)
                .collect(Collectors.toMap(Worker::getId, Worker::getName));
        model.addAttribute("headsOfDepartmentMap", headsOfDepartmentMap);
        Map<String, String> departmentsMap = departmentService.getAll().stream()
                .collect(Collectors.toMap(Department::getId, Department::getName));
        model.addAttribute("departmentsMap", departmentsMap);
        return "logHeadOfDepartmentAddOrEdit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("logHeadOfDepartmentForm") LogHeadOfDepartmentForm logHeadOfDepartmentForm) {
        LogHeadOfDepartment logHeadOfDepartmentWhichEdit = logHeadOfDepartmentService.getById(id);
        logHeadOfDepartmentWhichEdit = new LogHeadOfDepartment(
                id,
                logHeadOfDepartmentForm.getName(),
                logHeadOfDepartmentForm.getDescription(),
                logHeadOfDepartmentWhichEdit.getCreationDate(),
                null,
                logHeadOfDepartmentForm.getBegDateParsed(),
                logHeadOfDepartmentForm.getEndDateParsed(),
                (CanLead) workerService.getById(logHeadOfDepartmentForm.getHeadOfDepartmentId()),
                departmentService.getById(logHeadOfDepartmentForm.getDepartmentId()));
        logHeadOfDepartmentService.edit(logHeadOfDepartmentWhichEdit);
        return "redirect:/web/log_head_of_department/get/list";
    }

    @RequestMapping(value = "/remove_from_position/{id}", method = RequestMethod.GET)
    String removeFromPosition(@PathVariable("id") String id){
        this.logHeadOfDepartmentService.removeFromPosition(id);
        return "redirect:/web/log_head_of_department/get/list";
    }
}
