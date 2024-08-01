package com.example.testpostgre.service.truckdriverservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.testpostgre.repository.truckdriver.TruckDriverRepository;
import com.example.testpostgre.model.TruckDriver;

import java.util.List;
import java.util.Optional;

@Service
public class TruckDriverServiceImpl implements TruckDriverService {
    @Autowired
    private TruckDriverRepository teacherRepository;

    @Override
    public void save(TruckDriver teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public int[] saveStudentsList(List<TruckDriver> teachers) {
        teacherRepository.saveAll(teachers);
        return new int[0];
    }

    @Override
    public void update(TruckDriver teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void delete(TruckDriver teacher) {
        teacherRepository.delete(teacher);
    }

    @Override
    public List<TruckDriver> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public void deleteAll() {
        teacherRepository.deleteAll();
    }



    @Override
    public Optional<TruckDriver> findById(Long id) {
        return teacherRepository.findById(id);
    }

}
