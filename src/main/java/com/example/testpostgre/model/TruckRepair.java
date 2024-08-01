package com.example.testpostgre.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
//import jakarta.persistence.*;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "truck_repair")
public class TruckRepair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="day")
    private int day;

    @ManyToOne
    @JoinColumn(name = "truckid", nullable=false)
    private Truck truckId;

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;


    @Override
    public String toString() {
        return "TruckRepair{" +
                "id=" + id +
                ", day=" + day +
                ", truckId=" + truckId +
                ", createAt="+ createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TruckRepair that = (TruckRepair) o;
        return day == that.day && Objects.equals(id, that.id) && Objects.equals(truckId, that.truckId)
                && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, day, truckId, createdAt);
    }
}
