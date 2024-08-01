package com.example.testpostgre.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.testpostgre.service.createordrservice.CreateOrderService;
import com.example.testpostgre.service.createrouteservice.CreateRouteService;

@Log4j2
@Service
public class startAutobaseWork {
    @Autowired
    CreateRouteService createRouteService;

    @Autowired
    CreateOrderService createOrderService;

    public void start() throws InterruptedException {
        log.info("Autobase starts working");
        int day=1;
        int number=0;
        while (number < 10){
            createOrderService.createOrders(10);
            log.info("Day "+day+" :");
            log.info("Autobase orders are created");
            createRouteService.createRoutes(day);
            log.info("Autobase routs are created");
            Thread.sleep(30000);
            createRouteService.finishRoutes();
            createRouteService.checkRepairtruck();
            log.info("Autobase routs are finished");
            day++;
            ++number;
        }
    }

}
