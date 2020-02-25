package edu.stev.cursach.service.group.impls;

import edu.stev.cursach.dao.group.impls.GroupDaoImplFake;
import edu.stev.cursach.dao.group.repository.GroupRepository;
import edu.stev.cursach.model.Group;
import edu.stev.cursach.service.group.interfaces.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
@Service
public class GroupServiceImpl implements IGroupService {
    @Autowired
    GroupDaoImplFake dao;

    @Autowired
    GroupRepository repository;

    @PostConstruct
    void init (){
        List<Group> list = dao.getAll();
        repository.saveAll(list); //save table from list to mongodb
    }

    @Override
    public Group save(Group group) {
        return null;
    }

    @Override
    public Group get(String is) {
        return null;
    }

    @Override
    public List<Group> getAll() {
        return repository.findAll();
    }

    @Override
    public Group edit(Group group) {
        return null;
    }

    @Override
    public Group delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

}
