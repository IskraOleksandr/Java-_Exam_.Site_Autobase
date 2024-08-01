package com.example.testpostgre.service.createordrservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.testpostgre.model.Cargo;
import com.example.testpostgre.model.Destination;
import com.example.testpostgre.model.Order;
import com.example.testpostgre.service.cargo.CargoService;
import com.example.testpostgre.service.destination.DestinationService;
import com.example.testpostgre.service.order.OrderService;

import java.util.List;
import java.util.Random;

@Service
public class CreateOrderServiceImpl  implements CreateOrderService{
    @Autowired
    DestinationService destService;

    @Autowired
    CargoService cargoService;

@Autowired
    OrderService orderService;

    private static final Random RANDOM_GENERATOR = new Random();

    @Override
    public void createOrders(int number){
        List<Destination> destinations=destService.findAll();
        List<Cargo> cargos=cargoService.findAll();
        for(int i=0;i<number;i++) {
            int indexDestination = RANDOM_GENERATOR.nextInt(0, destinations.size() - 1);
            int indexCargo = RANDOM_GENERATOR.nextInt(0, cargos.size() - 1);
            int weight = RANDOM_GENERATOR.nextInt(1, 34);
            Order order = new Order();
            order.setCargoId(cargos.get(indexCargo));
            order.setDestinationId(destinations.get(indexDestination));
            order.setWeight(weight);
            order.setStatus("ожидает");
            orderService.save((order));
        }
    }
}
