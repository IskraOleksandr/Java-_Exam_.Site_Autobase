package com.example.testpostgre.service.statisticservice;

import com.example.testpostgre.dto.SalaryDTO;
import com.example.testpostgre.model.Order;

import java.util.List;

public interface StatisticService {
    SalaryDTO findDriver();
    String findCargo();
    String findDestination();
    String findMinWeightCargo();
    List<Order> findCargoIn();
}
