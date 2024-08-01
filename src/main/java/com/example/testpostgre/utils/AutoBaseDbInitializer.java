package com.example.testpostgre.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.testpostgre.exception.FileException;
import com.example.testpostgre.model.*;
import com.example.testpostgre.service.appuserservice.AppUserService;
import com.example.testpostgre.service.autobaseservice.AutoBaseService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log4j2
@Service
public class AutoBaseDbInitializer {


    private final AutoBaseService autobaseInitService;

    @Autowired
    private AppUserService appUserService;

    public AutoBaseDbInitializer(AutoBaseService autobaseInitService) {
        this.autobaseInitService = autobaseInitService;
    }


    public void deleteAllRowsInDB() {
        autobaseInitService.deleteAllRowsInDB();
        log.debug("All rows in DB was deleted");
    }

    public void createUsers() {
        AppUser apu1 = new AppUser();
        apu1.setUserId(1L);//
        apu1.setUserName("admin");
        apu1.setEncrytedPassword("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
        apu1.setEnabled(true);
        appUserService.save(apu1);

        AppUser apu2 = new AppUser();
        apu2.setUserId(2L);//
        apu2.setUserName("user");
        apu2.setEncrytedPassword("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
        apu2.setEnabled(true);
        appUserService.save(apu2);
    }

    public void createDrivers() throws FileException {
        List<Driver>list=autobaseInitService.findAllDrivers();
        if(list.isEmpty()) {
            List<Driver> drivers = new ArrayList<>();
            String driversFileName = PropertyFactory.getInstance().getProperty().getProperty("data.drivers");
            try (Stream<String> lineStream = Files.lines(Paths.get(driversFileName))) {
                for (var currentString : lineStream.collect(Collectors.toList())) {
                    String[] strings = currentString.split(":");
                    Driver driver = new Driver();
                    driver.setFullName(strings[0]);
                    driver.setAge(Integer.parseInt(strings[1]));
                    driver.setExpirience(Integer.parseInt(strings[2]));
                    driver.setAvailable(true);

                    drivers.add(driver);
                }
                autobaseInitService.saveDriverList(drivers);
                log.debug("Drivers are created");
            } catch (IOException exception) {
                log.error("Error open source courses file");
                throw new FileException("Error with source courses file");
            }
        }
    }

    public void createTrucks() throws FileException {

        List<Truck> list = autobaseInitService.findAllTrucks();
        if (list.isEmpty()) {
            String trucksFileName = PropertyFactory.getInstance().getProperty().getProperty("data.trucks");
            List<Truck> trucks = new ArrayList<>();
            try (Stream<String> lineStream = Files.lines(Paths.get(trucksFileName))) {
                for (var currentString : lineStream.collect(Collectors.toList())) {
                    String[] strings = currentString.split(":");
                    Truck truck = new Truck();
                    truck.setName(strings[0]);
                    truck.setAvailable(true);
                    truck.setRepairability(true);
                    truck.setMaxWeight(Integer.parseInt(strings[1]));

                    trucks.add(truck);
                }
                autobaseInitService.saveTruckList(trucks);
                log.debug("Trucks are created");
            } catch (IOException exception) {
                log.error("Error open source trucks file");
                throw new FileException("Error with source trucks file");
            }
        }
    }

    public void createDestinations() throws FileException {
        List<Destination> list = autobaseInitService.findAllDestination();
        if (list.isEmpty()) {
            String trucksFileName = PropertyFactory.getInstance().getProperty().getProperty("data.destination");
            List<Destination> dests = new ArrayList<>();
            try (Stream<String> lineStream = Files.lines(Paths.get(trucksFileName))) {
                for (var currentString : lineStream.collect(Collectors.toList())) {
                    String[] strings = currentString.split(":");
                    Destination des = new Destination();
                    des.setName(strings[0]);
                    des.setSumma(Double.parseDouble(strings[1]));
                    dests.add(des);
                }
                autobaseInitService.saveDestinationList(dests);
                log.debug("Destinations are created");
            } catch (IOException exception) {
                log.error("Error open source distantions file");
                throw new FileException("Error with source distantions file");
            }
        }
    }

    public void createCargos() throws FileException {

        List<Cargo> list = autobaseInitService.findAllCargos();
        if (list.isEmpty()) {
            String cargoFileName = PropertyFactory.getInstance().getProperty().getProperty("data.cargo");
            List<Cargo> cargos = new ArrayList<>();
            try (Stream<String> lineStream = Files.lines(Paths.get(cargoFileName))) {
                for (var currentString : lineStream.toList()) {
                    String[] strings = currentString.split(":");
                   Cargo cargo = new Cargo();
                    cargo.setName(strings[0]);
                    cargo.setLevelDriverExpirience(Integer.parseInt(strings[1]));

                    cargos.add(cargo);
                }
                autobaseInitService.saveCargoList(cargos);
                log.debug("Cargos are created");
            } catch (IOException exception) {
                log.error("Error open source cargo file");
                throw new FileException("Error with source cargo file");
            }
        }
    }

    public void createOrders(int number){

        List<Order> list=autobaseInitService.findAllOrders();
        if(list.isEmpty()) {
             autobaseInitService.createOrders(number);
        }
    }


}
