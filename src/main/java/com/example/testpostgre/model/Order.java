package com.example.testpostgre.model;

import lombok.Getter;
import lombok.Setter;
//import jakarta.persistence.*;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="weight")
    int weight;

    @ManyToOne
    @JoinColumn(name="cargoid", nullable=false)
    Cargo cargoId;

    @ManyToOne
    @JoinColumn(name="destinationid", nullable=false)
    Destination destinationId;

    @Column(name="status")
    String status;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", weight=" + weight +
                ", cargoId=" + cargoId +
                ", destinationId=" + destinationId +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return weight == order.weight && Objects.equals(id, order.id) && Objects.equals(cargoId, order.cargoId) && Objects.equals(destinationId, order.destinationId) && Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weight, cargoId, destinationId, status);
    }
}
