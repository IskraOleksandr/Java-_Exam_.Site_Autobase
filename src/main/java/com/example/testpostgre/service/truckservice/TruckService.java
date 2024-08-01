package com.example.testpostgre.service.truckservice;

import com.example.testpostgre.model.Truck;

import java.util.List;

public interface TruckService {
    void save(Truck subject) ;

    int[] saveStudentsList(List<Truck> subjects) ;

    void update(Truck subject) ;

    void delete(Truck subject) ;

    List<Truck> findAll() ;


    void deleteAll() ;

    List<Truck> findByIdLike(Long id);

}
