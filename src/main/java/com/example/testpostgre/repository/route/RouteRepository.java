package com.example.testpostgre.repository.route;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.testpostgre.model.Route;

import java.util.List;

@Repository
@Transactional
public interface RouteRepository extends JpaRepository<Route,Long> {
    List<Route> findByIdLike(Long id);


}
