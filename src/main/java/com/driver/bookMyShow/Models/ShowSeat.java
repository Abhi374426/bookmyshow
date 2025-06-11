package com.driver.bookMyShow.Models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "SHOW_SEATS")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Inheritance
public class ShowSeat extends AbstractPersistable {
    private String seatType;

    private Integer price;
//    @ManyToOne
//    @JoinColumn(name = "show_id")
//    private Show show;
}
