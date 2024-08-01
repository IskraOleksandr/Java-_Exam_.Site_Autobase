package com.example.testpostgre.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import com.example.testpostgre.exception.FileException;

@Log4j2
@Service
public class AutoBaseInitializer {

    private final AutoBaseDbInitializer dbInitializer;

    public AutoBaseInitializer(AutoBaseDbInitializer dbInitializer) {
        this.dbInitializer = dbInitializer;
    }

    public void autobaseInitialize() {
        try {
            log.info("Start autobase initialize");

            dbInitializer.deleteAllRowsInDB();


            //dbInitializer.createUsers();
            dbInitializer.createDrivers();
            dbInitializer.createTrucks();
            dbInitializer.createDestinations();
            dbInitializer.createCargos();

            log.info("End autobase initialize");
        } catch (FileException e) {
            log.error("error with source file names");
        }
    }

}
