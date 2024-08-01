package com.example.testpostgre.service.cargo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.testpostgre.repository.cargo.CargoRepository;
import com.example.testpostgre.model.Cargo;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService{
    @Autowired
    private CargoRepository rep;
    @Override
    public void save(Cargo g) {
        rep.save(g);
    }

    @Override
    public int[] saveStudentsList(List<Cargo> groups) {
        rep.saveAll(groups);
        return new int[0];
    }

    @Override
    public void update(Cargo group) {
             rep.save(group);
    }

    @Override
    public void delete(Cargo group) {
rep.delete(group);
    }

    @Override
    public List<Cargo> findAll() {
        return rep.findAll();
    }

    @Override
    public void deleteAll() {
rep.deleteAll();
    }

    @Override
    public List<Cargo> findByIdLike(Long id) {
        return rep.findByIdLike(id);
    }
}
