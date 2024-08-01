package com.example.testpostgre.repository.truck;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.testpostgre.model.Truck;

import java.util.List;

@Repository
@Transactional
public interface TruckRepository extends JpaRepository<Truck,Long> {



    List<Truck> findByIdLike( Long id);

}
