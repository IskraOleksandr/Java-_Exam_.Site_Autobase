package com.example.testpostgre.repository.salary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.testpostgre.model.Salary;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary,Long> {

    @Query(value = FIND_BY_ID, nativeQuery = true)
    List<Salary> findByIdLike(Long id);
    String FIND_BY_ID =
            """
            SELECT *
            FROM salary
            WHERE driverid = ?""";


}
