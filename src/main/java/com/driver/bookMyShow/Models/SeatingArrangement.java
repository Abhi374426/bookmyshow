package com.driver.bookMyShow.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "Seats_V1")
//@Data
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance
public class    SeatingArrangement extends AbstractPersistable {


    @Column(name = "Seat_Name")
    private String seatName;
    @Column(name = "Screen_Size")
    private String screenSize;
     @Column(name = "Seat_Type")
    private String seatType;

    @ManyToOne
    @JoinColumn(name = "Screen_id")
    @JsonIgnoreProperties({"capacitive", "theater", "seatingArrangementList"})
    private Screen screen;

}
