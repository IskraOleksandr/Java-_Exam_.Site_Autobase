package com.example.testpostgre.service.destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.testpostgre.repository.destination.DestinationRepository;
import com.example.testpostgre.model.Destination;

import java.util.List;

@Service
public class DestinationServiceImpl implements DestinationService{
    @Autowired
    DestinationRepository rep;
    @Override
    public void save(Destination group) {
        rep.save(group);
    }

    @Override
    public int[] saveStudentsList(List<Destination> groups) {
        rep.saveAll(groups);
        return new int[0];
    }

    @Override
    public void update(Destination group) {
rep.save(group);
    }

    @Override
    public void delete(Destination group) {
rep.delete(group);
    }

    @Override
    public List<Destination> findAll() {
        return rep.findAll();
    }

    @Override
    public void deleteAll() {
rep.deleteAll();
    }

    @Override
    public List<Destination> findByNameLike(String groupName) {
        return rep.findByNameLike(groupName);
    }
}
