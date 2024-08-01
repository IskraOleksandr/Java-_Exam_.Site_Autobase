package com.example.testpostgre.service.order;

import com.example.testpostgre.model.Order;

import java.util.List;

public interface OrderService {
    void save(Order group) ;

    int[] saveStudentsList(List<Order> groups) ;

    void update(Order group) ;

    void delete(Order group) ;

    List<Order> findAll() ;

    void deleteAll() ;

    List<Order> findByIdLike(Long id);

    List<Order> findAllFinished();
}
