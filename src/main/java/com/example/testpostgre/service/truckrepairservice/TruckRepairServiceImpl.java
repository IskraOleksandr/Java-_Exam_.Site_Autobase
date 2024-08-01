package com.example.testpostgre.service.truckrepairservice;

import com.example.testpostgre.dto.TruckRepairDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.testpostgre.repository.truckrepair.TruckRepairRepository;
import com.example.testpostgre.model.TruckRepair;

//import java.util.List;
import java.util.List;
import java.util.Optional;

@Service
public class TruckRepairServiceImpl implements TruckRepairService {

    @Autowired
    private TruckRepairRepository trRepository;

    public List<TruckRepairDTO> findWithRemainingRepairDays() {
        return trRepository.findWithRemainingRepairDays();
    }

    @Override
    public void save(TruckRepair timetable) {
        trRepository.save(timetable);
    }

    @Override
    public int[] saveStudentsList(List<TruckRepair> timetables) {
        trRepository.saveAll(timetables);
        return new int[0];
    }

    @Override
    public void update(TruckRepair timetable) {
        trRepository.save(timetable);
    }

    @Override
    public void delete(TruckRepair timetable) {
        trRepository.delete(timetable);
    }

    @Override
    public List<TruckRepair> findAll() {
        return trRepository.findAll();
    }


    @Override
    public void deleteAll() {
        trRepository.deleteAll();
    }


    @Override
    public Optional<TruckRepair> findById(Long id) {
        return trRepository.findById(id);
    }

}
