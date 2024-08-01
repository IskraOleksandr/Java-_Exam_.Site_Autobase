package com.example.testpostgre.repository.truckrepair;

import com.example.testpostgre.dto.TruckRepairDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.testpostgre.model.TruckRepair;

import java.util.List;

@Repository
@Transactional
public interface TruckRepairRepository extends JpaRepository<TruckRepair, Long> {
    @Query("SELECT new com.example.testpostgre.dto.TruckRepairDTO(tr.id, t.name, (tr.day - EXTRACT(DAY FROM age(CURRENT_TIMESTAMP, tr.createdAt)))) " +
            "FROM TruckRepair tr " +
            "JOIN Truck t ON tr.truckId.id > 0" +
            "WHERE t.repairability = TRUE")
    List<TruckRepairDTO> findWithRemainingRepairDays();
}
