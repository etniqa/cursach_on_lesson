package edu.stev.cursach.dao.classes.worker.repository;

import edu.stev.cursach.model.Worker;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkerRepository extends MongoRepository<Worker, String> {
}