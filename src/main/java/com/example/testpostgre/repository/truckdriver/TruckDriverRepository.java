package com.example.testpostgre.repository.truckdriver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.testpostgre.model.TruckDriver;

import java.util.List;

@Repository
@Transactional
public interface TruckDriverRepository extends JpaRepository<TruckDriver,Long> {

    List<TruckDriver> findByDriverIdLike(Long id);
    List<TruckDriver> findByTruckIdLike(Long id);

}
