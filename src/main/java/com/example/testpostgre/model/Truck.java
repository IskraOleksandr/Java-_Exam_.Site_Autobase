package com.example.testpostgre.model;

import lombok.Getter;
import lombok.Setter;
//import jakarta.persistence.*;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "truck")
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="maxweight")
    int maxWeight;
    @Column(name="available")
    boolean available;
    @Column(name="repairability")
    boolean repairability;
    @Column (name="name")
    String name;

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", maxWeight=" + maxWeight +
                ", available=" + available +
                ", repairability=" + repairability +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return maxWeight == truck.maxWeight && available == truck.available && repairability == truck.repairability && Objects.equals(id, truck.id) && Objects.equals(name, truck.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maxWeight, available, repairability, name);
    }
}
