package com.example.testpostgre.model;

import lombok.Getter;
import lombok.Setter;
//import jakarta.persistence.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="date")
    int date;

    @ManyToOne
    @JoinColumn(name="orderid", nullable=false)
    Order orderId;

    @ManyToOne
    @JoinColumn(name="truck_driverid", nullable=false)
    TruckDriver truckDriverId;
}
