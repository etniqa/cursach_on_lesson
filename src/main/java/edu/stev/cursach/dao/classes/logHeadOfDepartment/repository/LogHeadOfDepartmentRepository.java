package edu.stev.cursach.dao.classes.logHeadOfDepartment.repository;

import edu.stev.cursach.model.LogHeadOfDepartment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogHeadOfDepartmentRepository extends MongoRepository<LogHeadOfDepartment, String> {
}