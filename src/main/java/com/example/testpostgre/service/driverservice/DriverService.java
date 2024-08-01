package com.example.testpostgre.service.driverservice;

import com.example.testpostgre.model.Driver;

import java.util.List;

public interface DriverService {

    void save(Driver group) ;

    int[] saveStudentsList(List<Driver> groups) ;

    void update(Driver group) ;

    void delete(Driver group) ;

    List<Driver> findAll() ;

    void deleteAll() ;

    List<Driver> findByFullNameLike(String groupName);
    List<Driver> findByIdLike(Long id);

}
