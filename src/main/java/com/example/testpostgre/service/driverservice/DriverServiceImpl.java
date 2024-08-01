package com.example.testpostgre.service.driverservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.testpostgre.repository.driver.DriverRepository;
import com.example.testpostgre.model.Driver;

import java.util.Comparator;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository groupRepository;

    @Override
    public void save(Driver group) {
        groupRepository.save(group);
    }

    @Override
    public int[] saveStudentsList(List<Driver> groups) {
        groupRepository.saveAll(groups);
        return new int[0];
    }

    @Override
    public void update(Driver group) {
        groupRepository.save(group);
    }

    @Override
    public void delete(Driver group) {
        groupRepository.delete(group);
    }

    @Override
    public List<Driver> findAll() {
        List<Driver> drivers=groupRepository.findAll();
        drivers.sort(Comparator.comparing(Driver::getFullName));
        return drivers;
    }

    @Override
    public void deleteAll() {
        groupRepository.deleteAll();
    }

    @Override
    public List<Driver> findByFullNameLike(String groupName) {
        return groupRepository.findByFullNameLike(groupName);
    }

    @Override
    public List<Driver> findByIdLike(Long id) {
        return groupRepository.findByIdLike((id));
    }

}
