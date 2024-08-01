package com.example.testpostgre.service.autobaseservice;

import com.example.testpostgre.model.*;

import java.util.List;


public interface AutoBaseService {

    List<Truck> findAllTrucks();

   List<Salary> findAllSalary();

    List<TruckDriver> findAllTruckDriver();
    List<Cargo> findAllCargos();

    List<Driver> findAllDrivers();
    List<Destination> findAllDestination();
    List<Order> findAllOrders();

    void deleteAllRowsInDB();

    void saveDriverList(List<Driver> groups);

    void saveTruckList(List<Truck> subjects);

    void saveSalaryList(List<Salary> students);

    void saveTruckDriverList(List<TruckDriver> teachers);

    void saveTruckRepairList(List<TruckRepair> timetables);
    void saveDestinationList(List<Destination> timetables);

   void saveCargoList(List<Cargo> dest);
    void createOrders(int number);

}
