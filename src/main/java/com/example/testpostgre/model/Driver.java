package com.example.testpostgre.model;

import lombok.Getter;
import lombok.Setter;
//import jakarta.persistence.*;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="full_name")
    private String fullName;

    @Column(name="expirience")
    private int expirience;

    @Column(name="age")
    int age;

    @Column(name="available")
    boolean available;

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", Name='" + fullName + '\'' +
                ", expirience=" + expirience +
                ", age=" + age +
                ", available=" + available +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return expirience == driver.expirience && age == driver.age && available == driver.available && Objects.equals(id, driver.id) && Objects.equals(fullName, driver.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, expirience, age, available);
    }
}
