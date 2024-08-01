package com.example.testpostgre.service.statisticservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.testpostgre.dto.SalaryDTO;
import com.example.testpostgre.model.Driver;
import com.example.testpostgre.model.Order;
import com.example.testpostgre.model.Salary;
import com.example.testpostgre.service.driverservice.DriverService;
import com.example.testpostgre.service.order.OrderService;
import com.example.testpostgre.service.salaryservice.SalaryService;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StatisticServiceImpl implements StatisticService{

    @Autowired
    private DriverService dService;

    @Autowired
    private SalaryService salaryService;

    @Autowired
    private OrderService orderService;

    @Override
    public SalaryDTO findDriver(){
        List<Driver> drivers=dService.findAll();
        double sum=0;
        SalaryDTO sal = new SalaryDTO();
        for(var driver:drivers) {
            List<Salary> salary = salaryService.findByIdLike(driver.getId());
            double summa = 0;
            for (var s : salary) {
                summa += s.getSumma();
            }
            if(sum<summa) {
                sum=summa;
                sal.setSalary(salary);
                sal.setAllSumma(summa);
                sal.setName(salary.get(0).getDriverId().getFullName());
            }
        }
        return sal;
    }
    @Override
    public String findCargo(){
        List<Order> orders= orderService.findAllFinished();
        return   orders.stream()
                .map(order -> order.getCargoId().getName()) // Преобразуем Order в String (имя груза)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Группируем по имени груза и подсчитываем частоту
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()) // Находим запись с максимальной частотой
                .map(Map.Entry::getKey) // Извлекаем имя груза
                .orElse(null); // В случае, если список заказов пуст, возвращаем null


    }

    @Override
    public String findDestination(){
        List<Order> orders= orderService.findAllFinished();
        return   orders.stream()
                .map(order -> order.getDestinationId().getName())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Группируем по названию и подсчитываем частоту
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()) // Находим запись с максимальной частотой
                .map(Map.Entry::getKey) // Извлекаем название пункта доставки
                .orElse(null); // В случае, если список заказов пуст, возвращаем null


    }
    @Override
    public String findMinWeightCargo() {

        List<Order> orders = orderService.findAllFinished();
        Optional<Order> minWeight = orders.stream()
                .min(Comparator.comparingInt(Order::getWeight));

        if (minWeight.isPresent()) {
            return  minWeight.get().getCargoId().getName()+" ("+ minWeight.get().getWeight()+")";
        }
        return null;
    }
    @Override
    public List<Order> findCargoIn(){
        List<Order> orders = orderService.findAllFinished();
        List<Order> ord=new ArrayList<>();
        for (var  o :orders){
            if(Objects.equals(o.getDestinationId().getName(), "Vinnitsa")){
                ord.add(o);
            }
        }
        return ord;
    }
}
