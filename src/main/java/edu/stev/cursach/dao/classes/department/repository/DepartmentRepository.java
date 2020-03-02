package edu.stev.cursach.dao.classes.department.repository;

import edu.stev.cursach.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, String> {
}
