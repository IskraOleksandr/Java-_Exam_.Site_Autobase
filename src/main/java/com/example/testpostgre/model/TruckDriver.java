package com.example.testpostgre.model;

import lombok.Getter;
import lombok.Setter;
//import jakarta.persistence.*;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "truck_driver")
public class TruckDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="truckid", nullable=false)
    private Truck truckId;

    @ManyToOne
    @JoinColumn(name="driverid", nullable=false)
    private Driver driverId;

    @Override
    public String toString() {
        return "truck_driver{" +
                "id=" + id +
                ", truckId=" + truckId +
                ", driverId=" + driverId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TruckDriver that = (TruckDriver) o;
        return Objects.equals(id, that.id) && Objects.equals(truckId, that.truckId) && Objects.equals(driverId, that.driverId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, truckId, driverId);
    }
}
