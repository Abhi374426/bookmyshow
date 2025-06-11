package com.driver.bookMyShow.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Table(name = "Screen")
//@Data
@Setter
@Getter
@SQLDelete(sql = "UPDATE Screen SET is_deleted=true WHERE id=?")
@Where(clause = "is_deleted=false")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance
public class Screen extends AbstractPersistable {


    @Column(name = "Screen_type")
    private String screenType;
    @ManyToOne
    @JoinColumn(name = "theater_id")
    @JsonIgnoreProperties("screens")
    private Theater theater;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "capacitive_id")
//    @JsonIgnoreProperties("screen")
//    private Capacitive capacitive;

//    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("screen")
//    private List<SeatingArrangement> seatingArrangementList;

//    @OneToMany(mappedBy = "screen",cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("screen")
//    private List<Show> shows;

}