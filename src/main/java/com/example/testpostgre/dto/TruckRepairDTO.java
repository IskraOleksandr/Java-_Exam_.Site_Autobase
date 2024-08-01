package com.example.testpostgre.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class TruckRepairDTO {

    private Long id;

    @Column(name = "truckName", updatable = false)
    private String truckName;

    @Column(name = "remainingDays", updatable = false)
    private int remainingDays;

    public TruckRepairDTO(Long id, String truckName, int remainingDays) {
        this.id = id;
        this.truckName = truckName;
        this.remainingDays = remainingDays;
    }
}
