package com.example.testpostgre.model;

import lombok.Getter;
import lombok.Setter;
//import jakarta.persistence.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "oder_route")
public class OrderRoute {
    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name="orderid", nullable=false)
    Order orderId;

    @ManyToOne
    @JoinColumn(name="routeid", nullable=false)
    Route routeId;
}
