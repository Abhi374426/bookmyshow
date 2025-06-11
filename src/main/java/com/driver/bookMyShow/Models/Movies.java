package com.driver.bookMyShow.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.lang.model.element.Name;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "MOVIES")
@SuperBuilder
@AllArgsConstructor
@SQLDelete(sql = "UPDATE MOVIES SET is_deleted=true WHERE id=?")
@Where(clause = "is_deleted=false")
@NoArgsConstructor
@Inheritance
public class Movies extends AbstractPersistable {
    @Column(name = "movies_name", nullable = false)
    private String name;
    @Column(name = "movies_desc")
    private String description;
    @Column(name = "movies_duration")
    private Integer duration;
    @Column(name = "language")
    private String language;
    @Column(name = "genre")
    private String genre;
    @Column(name = "releaseDate")
    private LocalDate releaseDate;
    @Column(precision = 3,scale = 2)
    private BigDecimal rating;
    @OneToMany(mappedBy ="movies" ,cascade = CascadeType.ALL)
    @JsonIgnoreProperties("movies")
    private List<Show> shows;


}
