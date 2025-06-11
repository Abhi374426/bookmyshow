package com.driver.bookMyShow.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "Capacity_V1")
//@Data
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance

public class Capacitive extends AbstractPersistable{

    private int diamond;
    private int gold;
    private int silver;
//    @OneToOne(mappedBy = "capacitive")
//    @JsonIgnoreProperties({"capacitive", "theater", "seatingArrangementList"})
//    private Screen screen;

}
