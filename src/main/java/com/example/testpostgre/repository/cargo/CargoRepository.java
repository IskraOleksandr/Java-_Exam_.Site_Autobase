package com.example.testpostgre.repository.cargo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.testpostgre.model.Cargo;

import java.util.List;

@Repository
@Transactional
public interface CargoRepository extends JpaRepository<Cargo,Long> {
    List<Cargo> findByIdLike(Long id);
}
