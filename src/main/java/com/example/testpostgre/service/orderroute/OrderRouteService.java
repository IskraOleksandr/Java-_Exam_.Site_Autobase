package com.example.testpostgre.service.orderroute;

import com.example.testpostgre.model.OrderRoute;

import java.util.List;

public interface OrderRouteService {
    void save(OrderRoute group) ;

    int[] saveStudentsList(List<OrderRoute> groups) ;

    void update(OrderRoute group) ;

    void delete(OrderRoute group) ;

    List<OrderRoute> findAll() ;

    void deleteAll() ;

    List<OrderRoute> findByIdLike(Long id);
}
