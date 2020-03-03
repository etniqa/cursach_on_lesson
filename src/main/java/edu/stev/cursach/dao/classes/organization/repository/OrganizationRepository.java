package edu.stev.cursach.dao.classes.organization.repository;

import edu.stev.cursach.model.classes.Organization;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrganizationRepository extends MongoRepository<Organization, String> {
}
