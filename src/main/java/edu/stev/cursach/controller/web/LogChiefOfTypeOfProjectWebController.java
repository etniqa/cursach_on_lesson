package edu.stev.cursach.controller.web;

import edu.stev.cursach.form.LogChiefOfTypeOfAgreementForm;
import edu.stev.cursach.model.pojos.*;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.classes.department.impls.DepartmentServiceImpl;
import edu.stev.cursach.service.classes.equipment.impls.EquipmentServiceImpls;
import edu.stev.cursach.service.classes.logChiefOfTypeOfProject.impls.LogChiefOfTypeOfProjectServiceImpl;
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

import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/log_chief_of_type_of_project")
public class LogChiefOfTypeOfProjectWebController {
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
    LogChiefOfTypeOfProjectServiceImpl logChiefOfTypeOfProjectService;

    @RequestMapping("/get/list")
    String getAll(Model model){
        model.addAttribute("logChiefOfTypeOfProjects", logChiefOfTypeOfProjectService.getAll());
        return "logChiefOfTypeOfProjectList";
    }
    @RequestMapping("/delete/{id}")
    String delete(@PathVariable("id") String id) {
        logChiefOfTypeOfProjectService.delete(id);
        return "redirect:/web/log_chief_of_type_of_project/get/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    String add(Model model) {
        LogChiefOfTypeOfAgreementForm logChiefOfTypeOfAgreementForm = new LogChiefOfTypeOfAgreementForm();
        Map<String, String> agreementsMap = typeOfAgreementService.getAll().stream()
                .collect(Collectors.toMap(TypeOfAgreement::getId, TypeOfAgreement::getName));
        Map<String, String> canLeadsMap = workerService.getAll().stream()
                .filter(worker -> worker instanceof CanLead)
                .collect(Collectors.toMap(Worker::getId, Worker::getName));

        model.addAttribute("agreementsMap", agreementsMap);
        model.addAttribute("canLeadsMap", canLeadsMap);
        model.addAttribute("logChiefOfTypeOfAgreementForm", logChiefOfTypeOfAgreementForm);
        return "logChiefOfTypeOfProjectAdd";
    }

    //for post filled form for some bean to add
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    String add(@ModelAttribute("logChiefOfTypeOfAgreementForm") LogChiefOfTypeOfAgreementForm logChiefOfTypeOfAgreementForm) {
        LogChiefOfTypeOfProject newLogChiefOfTypeOfProject = new LogChiefOfTypeOfProject(null,
                logChiefOfTypeOfAgreementForm.getName(), logChiefOfTypeOfAgreementForm.getDescription(), null,
                null,  logChiefOfTypeOfAgreementForm.getBegDateParsed(), logChiefOfTypeOfAgreementForm.getEndDateParsed(),
                typeOfAgreementService.get(logChiefOfTypeOfAgreementForm.getAgreementId()), (CanLead) workerService.get(logChiefOfTypeOfAgreementForm.getChiefId()));
        logChiefOfTypeOfProjectService.save(newLogChiefOfTypeOfProject);
        return "redirect:/web/log_chief_of_type_of_project/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        LogChiefOfTypeOfProject logChiefOfTypeOfProjectWhichEdit = logChiefOfTypeOfProjectService.get(id);

        LogChiefOfTypeOfAgreementForm logChiefOfTypeOfAgreementForm = new LogChiefOfTypeOfAgreementForm(logChiefOfTypeOfProjectWhichEdit.getName(),
                logChiefOfTypeOfProjectWhichEdit.getDescription(),
                logChiefOfTypeOfProjectWhichEdit.getBegDate() == null ? "null" : logChiefOfTypeOfProjectWhichEdit.getBegDate().toString(),
                logChiefOfTypeOfProjectWhichEdit.getEndDate() == null ? "null" : logChiefOfTypeOfProjectWhichEdit.getEndDate().toString(),
                logChiefOfTypeOfProjectWhichEdit.getAgreement().getId(), logChiefOfTypeOfProjectWhichEdit.getChief().getId());

        Map<String, String> agreementsMap = typeOfAgreementService.getAll().stream()
                .collect(Collectors.toMap(TypeOfAgreement::getId, TypeOfAgreement::getName));
        Map<String, String> canLeadsMap = workerService.getAll().stream()
                .filter(worker -> worker instanceof CanLead)
                .collect(Collectors.toMap(Worker::getId, Worker::getName));

        model.addAttribute("agreementsMap", agreementsMap);
        model.addAttribute("canLeadsMap", canLeadsMap);
        model.addAttribute("logChiefOfTypeOfAgreementForm", logChiefOfTypeOfAgreementForm);
        return "logChiefOfTypeOfProjectAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("logChiefOfTypeOfAgreementForm") LogChiefOfTypeOfAgreementForm logChiefOfTypeOfAgreementForm) {
        LogChiefOfTypeOfProject logChiefOfTypeOfProjectWhichEdit = logChiefOfTypeOfProjectService.get(id);
        logChiefOfTypeOfProjectWhichEdit = new LogChiefOfTypeOfProject(id, logChiefOfTypeOfAgreementForm.getName(),
                logChiefOfTypeOfAgreementForm.getDescription(), logChiefOfTypeOfProjectWhichEdit.getCreationDate(),
                null, logChiefOfTypeOfAgreementForm.getBegDateParsed(), logChiefOfTypeOfAgreementForm.getEndDateParsed(),
                typeOfAgreementService.get(logChiefOfTypeOfAgreementForm.getAgreementId()), (CanLead) workerService.get(logChiefOfTypeOfAgreementForm.getChiefId()));

        logChiefOfTypeOfProjectService.edit(logChiefOfTypeOfProjectWhichEdit);
        return "redirect:/web/log_chief_of_type_of_project/get/list";
    }
}
