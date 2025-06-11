package com.driver.bookMyShow.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Table(name = "THEATER")
@Getter
@Setter
@SuperBuilder
@SQLDelete(sql="UPDATE THEATER SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance
public class Theater extends AbstractPersistable {

    @Column(name = "THEATER_NAME")
    private String name;

    @Column(name = "ADDRESS", unique = true)
    private String address;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"theater", "capacitive", "seatingArrangementList"})
    private List<Screen> screens;

     @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
     @JsonIgnoreProperties("theater")
     private List<TheaterFacility> theaterFacilities;
}
