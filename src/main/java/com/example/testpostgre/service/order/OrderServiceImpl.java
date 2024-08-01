package com.example.testpostgre.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.testpostgre.repository.oder.OrderRepository;
import com.example.testpostgre.model.Order;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository rep;
    @Override
    public void save(Order group) {
        rep.save(group);
    }

    @Override
    public int[] saveStudentsList(List<Order> groups) {
        rep.saveAll(groups);
        return new int[0];
    }

    @Override
    public void update(Order group) {
rep.save(group);
    }

    @Override
    public void delete(Order group) {
rep.delete(group);

    }

    @Override
    public List<Order> findAll() {
        return rep.findAll();
    }

    @Override
    public void deleteAll() {
rep.deleteAll();
    }

    @Override
    public List<Order> findByIdLike(Long id) {
        return rep.findByIdLike(id);
    }

    @Override
    public List<Order> findAllFinished() {
        return rep.findAllfinished();
    }


}
