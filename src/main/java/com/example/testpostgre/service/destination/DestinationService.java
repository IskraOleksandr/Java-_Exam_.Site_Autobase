package com.example.testpostgre.service.destination;

import com.example.testpostgre.model.Destination;

import java.util.List;

public interface DestinationService {
    void save(Destination group) ;

    int[] saveStudentsList(List<Destination> groups) ;

    void update(Destination group) ;

    void delete(Destination group) ;

    List<Destination> findAll() ;

    void deleteAll() ;

    List<Destination> findByNameLike(String groupName);
}
