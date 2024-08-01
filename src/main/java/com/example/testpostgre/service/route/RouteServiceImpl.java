package com.example.testpostgre.service.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.testpostgre.repository.route.RouteRepository;
import com.example.testpostgre.model.Route;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService{

    @Autowired
    RouteRepository rep;
    @Override
    public void save(Route group) {
        rep.save(group);
    }

    @Override
    public int[] saveStudentsList(List<Route> groups) {
        rep.saveAll(groups);
        return new int[0];
    }

    @Override
    public void update(Route group) {
rep.save(group);
    }

    @Override
    public void delete(Route group) {
rep.delete(group);
    }

    @Override
    public List<Route> findAll() {
        return rep.findAll();
    }

    @Override
    public void deleteAll() {
rep.deleteAll();
    }

    @Override
    public List<Route> findByIdLike(Long id) {
        return rep.findByIdLike(id);
    }


}
