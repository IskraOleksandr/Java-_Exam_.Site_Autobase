package com.example.testpostgre.service.route;

import com.example.testpostgre.model.Route;

import java.util.List;

public interface RouteService {
    void save(Route group) ;

    int[] saveStudentsList(List<Route> groups) ;

    void update(Route group) ;

    void delete(Route group) ;

    List<Route> findAll() ;

    void deleteAll() ;

    List<Route> findByIdLike(Long id);

}
