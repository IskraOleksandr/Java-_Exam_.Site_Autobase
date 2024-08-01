package com.example.testpostgre.model;

import lombok.Getter;
import lombok.Setter;
//import jakarta.persistence.*;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "cargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="name")
    String name;

    @Column(name="leveldriverexpirience")
    int levelDriverExpirience;

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", levelDriverExpirience=" + levelDriverExpirience +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return levelDriverExpirience == cargo.levelDriverExpirience && Objects.equals(id, cargo.id) && Objects.equals(name, cargo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, levelDriverExpirience);
    }
}
