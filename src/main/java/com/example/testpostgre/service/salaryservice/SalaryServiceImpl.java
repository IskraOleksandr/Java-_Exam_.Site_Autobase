package com.example.testpostgre.service.salaryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.testpostgre.repository.salary.SalaryRepository;
import com.example.testpostgre.model.Salary;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryRepository studentRepository;

    @Override
    public void save(Salary student) {
        studentRepository.save(student);
    }

    @Override
    public int[] saveStudentsList(List<Salary> students) {
        studentRepository.saveAll(students);
        return new int[1];
    }

    @Override
    public void update(Salary student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Salary student) {
        studentRepository.delete(student);
    }

    @Override
    public List<Salary> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }



    @Override
    public List<Salary> findByIdLike(Long id) {
        return studentRepository.findByIdLike(id);
    }

}
