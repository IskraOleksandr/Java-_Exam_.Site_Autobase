package com.example.testpostgre.service.truckservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.testpostgre.repository.truck.TruckRepository;
import com.example.testpostgre.model.Truck;

import java.util.List;

@Service
public class TruckServiceImpl implements TruckService {

    @Autowired
    private TruckRepository subjectRepository;

    @Override
    public void save(Truck subject) {
        subjectRepository.save(subject);
    }

    @Override
    public int[] saveStudentsList(List<Truck> subjects) {
        subjectRepository.saveAll(subjects);
        return new int[0];
    }

    @Override
    public void update(Truck subject) {
        subjectRepository.save(subject);
    }

    @Override
    public void delete(Truck subject) {
        subjectRepository.delete(subject);
    }

    @Override
    public List<Truck> findAll() {
        return subjectRepository.findAll();
    }



    @Override
    public void deleteAll() {
        subjectRepository.deleteAll();
    }

    @Override
    public List<Truck> findByIdLike(Long id) {
        return subjectRepository.findByIdLike(id);
    }

}
