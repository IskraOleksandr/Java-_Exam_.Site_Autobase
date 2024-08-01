package com.example.testpostgre.model;

import lombok.Getter;
import lombok.Setter;
//import jakarta.persistence.*;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "salary")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "summa")
    double summa;

    @ManyToOne
    @JoinColumn(name="driverid", nullable=false)
    private Driver driverId;
    @ManyToOne
    @JoinColumn(name="routeid", nullable=false)
    private Route routeId;

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", summa=" + summa +
                ", driverId=" + driverId +
                ", routeId=" + routeId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary = (Salary) o;
        return Double.compare(summa, salary.summa) == 0 && Objects.equals(id, salary.id) && Objects.equals(driverId, salary.driverId) && Objects.equals(routeId, salary.routeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, summa, driverId, routeId);
    }

}
