package edu.stev.cursach.service.group.impls;

import edu.stev.cursach.dao.group.impls.GroupDaoImplFake;
import edu.stev.cursach.dao.group.repository.GroupRepository;
import edu.stev.cursach.model.Group;
import edu.stev.cursach.service.group.interfaces.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class GroupServiceImpl implements IGroupService {
    @Autowired
    GroupDaoImplFake dao;

    @Autowired
    GroupRepository repository;

    @PostConstruct
    void init (){
        List<Group> list = dao.getAll();
        repository.deleteAll();
        repository.saveAll(list); //save table from list to mongodb
    }

    @Override
    public Group save(Group group) {
        group.setId(UUID.randomUUID().toString());
        group.setDateModified(LocalDateTime.now());
        group.setCreationDate(LocalDateTime.now());
        return repository.save(group);
    }

    @Override
    public Group get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Group> getAll() {
        return repository.findAll();
    }

    @Override
    public Group edit(Group groupFromRequest) {
        //TODO change all fields to null, which wasn`t in requestBody in api.controller
        groupFromRequest.setDateModified(LocalDateTime.now());
        Group groupFromDB = repository.findById(groupFromRequest.getId()).orElse(null);
        groupFromRequest = this.refillFields(groupFromRequest, groupFromDB);
        return repository.save(groupFromRequest);
    }

    @Override
    public Group delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }


    Group refillFields(Group groupFromRequest, Group groupFromDB){
        return null;
    }
}
