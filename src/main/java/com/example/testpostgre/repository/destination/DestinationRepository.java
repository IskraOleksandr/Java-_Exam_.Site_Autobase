package com.example.testpostgre.repository.destination;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.testpostgre.model.Destination;

import java.util.List;

@Repository
@Transactional
public interface DestinationRepository extends JpaRepository<Destination,Long> {
    List<Destination> findByNameLike(String groupName);
}
