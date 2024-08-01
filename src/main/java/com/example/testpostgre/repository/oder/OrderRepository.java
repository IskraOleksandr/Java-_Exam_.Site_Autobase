package com.example.testpostgre.repository.oder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.testpostgre.model.Order;

import java.util.List;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByIdLike(Long id);

    String FIND_FINISH= """
            SELECT * 
            FROM orders             
            WHERE status = 'Завершен'          
            """;

    @Query(value = FIND_FINISH, nativeQuery = true)
    List<Order> findAllfinished();
}
