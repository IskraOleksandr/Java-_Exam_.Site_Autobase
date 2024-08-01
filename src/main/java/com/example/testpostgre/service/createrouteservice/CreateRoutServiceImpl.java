package com.example.testpostgre.service.createrouteservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.testpostgre.model.*;
import com.example.testpostgre.service.driverservice.DriverService;
import com.example.testpostgre.service.order.OrderService;
import com.example.testpostgre.service.route.RouteService;
import com.example.testpostgre.service.salaryservice.SalaryService;
import com.example.testpostgre.service.truckdriverservice.TruckDriverService;
import com.example.testpostgre.service.truckrepairservice.TruckRepairService;
import com.example.testpostgre.service.truckservice.TruckService;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class   CreateRoutServiceImpl implements CreateRouteService{
    @Autowired
    RouteService routeService;
    @Autowired
    OrderService orderService;
    @Autowired
    DriverService driverService;
    @Autowired
    TruckDriverService truckDriverService;
    @Autowired
    TruckService truckService;
    @Autowired
    SalaryService salaryService;
    @Autowired
    TruckRepairService truckRepairService;

    private static final Random RANDOM_GENERATOR = new Random();

    @Override
    public void createRoutes(int day ){
        List<Order> orders= orderService.findAll();
        for(var order:orders){
            if(Objects.equals(order.getStatus(), "ожидает")) {
                Truck truck = findTruckForRoute(order.getWeight());
                if (truck != null) {
                    Driver driver = findDriverForRoute(order.getCargoId().getLevelDriverExpirience());
                    if (driver != null) {
                        TruckDriver truckdriver = new TruckDriver();
                        truckdriver.setDriverId(driver);
                        truckdriver.setTruckId(truck);
                        truckDriverService.save(truckdriver);
                        Route route = new Route();
                        route.setOrderId(order);
                        route.setTruckDriverId(truckdriver);
                        route.setDate(day);
                        routeService.save(route);
                        order.setStatus("Выполняется");
                        orderService.update(order);
                        driver.setAvailable(false);
                        driverService.update(driver);
                        truck.setAvailable(false);
                        truckService.update(truck);
                    }
                }
            }
        }
    }

    @Override
    public void finishRoutes() {
        List<Route> routes= routeService.findAll();
        for(var route:routes){
            if(!Objects.equals(route.getOrderId().getStatus(), "Завершен")) {
                finishRoute(route);
            }
        }
    }

    private Truck findTruckForRoute(int weight){
        List<Truck >trucks= truckService.findAll();
        for(var truck:trucks){
            if(truck.getMaxWeight()>=weight && weight>=(truck.getMaxWeight()*70/100) && truck.isAvailable() && truck.isRepairability()){
                return truck;
            }
        }
        return null;
    }

    private Driver findDriverForRoute(int level){
        List<Driver> drivers=driverService.findAll();
        for(var driver :drivers){
            if(driver.getExpirience()>=level && driver.isAvailable()){
                return driver;
            }
        }
        return null;
    }


    private void finishRoute(Route route){
       Order order = route.getOrderId();
       Truck truck= route.getTruckDriverId().getTruckId();
       Driver driver = route.getTruckDriverId().getDriverId();
       driver.setAvailable(true);
       order.setStatus("Завершен");
       truck.setAvailable(true);
       truck.setRepairability(isGood());
       if(!truck.isRepairability()){
           TruckRepair tr=new TruckRepair();
           tr.setTruckId(truck);
           tr.setDay(days());
           truckRepairService.save(tr);
       }
       double summa=order.getDestinationId().getSumma();
       Salary salary=new Salary();
       salary.setRouteId(route);
       salary.setDriverId(driver);
       salary.setSumma(summa);
       salaryService.save(salary);
       truckService.update(truck);
       orderService.update(order);
       driverService.update(driver);

    }
    private boolean isGood(){
        int index = RANDOM_GENERATOR.nextInt(0, 1);
        if(index==0){
            return false;
        }
        return true;
    }

    private int days(){
        int index = RANDOM_GENERATOR.nextInt(1, 3);

            return index;

    }
@Override
    public void checkRepairtruck(){
        List<TruckRepair> trs = truckRepairService.findAll();
        Iterator<TruckRepair> iterator = trs.iterator();

        while (iterator.hasNext()) {
            TruckRepair tr = iterator.next();
            tr.setDay(tr.getDay() - 1);
            truckRepairService.update(tr);
            if (tr.getDay() == 0) {
                Truck truck=tr.getTruckId();
                truck.setRepairability(true);
                truckService.update(truck);
                truckRepairService.delete(tr);
                iterator.remove(); // Безопасное удаление элемента
            }
        }
    }
}
