package com.example.testpostgre.service.orderroute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.testpostgre.repository.orderroute.OrderRoutewRepository;
import com.example.testpostgre.model.OrderRoute;

import java.util.List;

@Service
public class OrderRouteServiceImpl implements OrderRouteService{
    @Autowired
    OrderRoutewRepository rep;
    @Override
    public void save(OrderRoute group) {
        rep.save(group);
    }

    @Override
    public int[] saveStudentsList(List<OrderRoute> groups) {
        rep.saveAll(groups);
        return new int[0];
    }

    @Override
    public void update(OrderRoute group) {
rep.save(group);
    }

    @Override
    public void delete(OrderRoute group) {
rep.delete(group);
    }

    @Override
    public List<OrderRoute> findAll() {
        return rep.findAll();
    }

    @Override
    public void deleteAll() {
rep.deleteAll();
    }

    @Override
    public List<OrderRoute> findByIdLike(Long id) {
        return rep.findByIdLike(id);
    }
}
