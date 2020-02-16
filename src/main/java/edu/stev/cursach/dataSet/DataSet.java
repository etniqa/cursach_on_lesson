package edu.stev.cursach.dataSet;

import edu.stev.cursach.model.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class DataSet {
    private Contract contractWithEvernote = new Contract("With Evernote", "description", LocalDateTime.now(),
            null, LocalDateTime.now(), null, null);
    private Organization softServeOrganiz = new Organization("SoftServe", "from Chernivtsi. There is no head organization", LocalDateTime.now(),
            null, null);
    private Department designDepartmentSoftServe = new Department("Department of design", "description", LocalDateTime.now(),
            null, softServeOrganiz, null);
    private Designer danyaDesigner = new Designer("Polyarush D.", "description about Danya", LocalDateTime.now(),
            null, designDepartmentSoftServe, contractWithEvernote, contractWithEvernote, 5);

    private Project projectWithApple = new Project("Apple project", "project with Apple",
            LocalDateTime.now(), null, LocalDateTime.now(), null, null);
    private Organization bizicoOrganiz = new Organization("Bizico", "suborganizaton of SoftServe",
            LocalDateTime.now(), null, softServeOrganiz);
    private Department departmentDesignBizico = new Department("Bizico design department", "",
            LocalDateTime.now(), null, bizicoOrganiz, null);
    private Engineer steveDesigner = new Engineer("Baranov S.", "form Novodnistrovsk!!!", LocalDateTime.now(),
            null, departmentDesignBizico, projectWithApple, projectWithApple);

    private Equipment motherboard = new Equipment("Motherboard", "motherboard",
            LocalDateTime.now(), null, departmentDesignBizico, projectWithApple);
    private Equipment processor = new Equipment("Processor", "proc", LocalDateTime.now(),
            null, departmentDesignBizico, projectWithApple);
    private Technician maxTechnician = new Technician("Max", "Lovely homeboy", LocalDateTime.now(), null,
            departmentDesignBizico, projectWithApple, motherboard, processor);


    public void initialize(){
        this.danyaDesigner.setDepartmentWhereWorks(designDepartmentSoftServe);
        this.designDepartmentSoftServe.setHeadOfDepartment(danyaDesigner);

        this.projectWithApple.setLeader(steveDesigner);
        this.departmentDesignBizico.setHeadOfDepartment(steveDesigner);
    }
    private List<Worker> workerList = Arrays.asList(
            danyaDesigner,
            steveDesigner,
            maxTechnician
            );

    public List<Worker> getWorkerList() {
        return workerList;
    }
}
