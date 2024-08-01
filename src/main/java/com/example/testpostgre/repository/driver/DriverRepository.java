package com.example.testpostgre.repository.driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.testpostgre.model.Driver;

import java.util.List;

@Repository
@Transactional
public interface DriverRepository extends JpaRepository<Driver,Long> {

    List<Driver> findByFullNameLike(String groupName);
    @Query(value = FIND_BY_ID, nativeQuery = true)
    List<Driver> findByIdLike(Long id);
    String FIND_BY_ID =
            """
            SELECT *
            FROM driver
            WHERE id = ?""";



}
