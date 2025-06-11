package com.driver.bookMyShow.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Table(name = "SHOWS")
@Setter
@Getter
@SuperBuilder
@SQLDelete(sql = "UPDATE SHOWS SET is_deleted=true WHERE id=?")
@Where(clause = "is_deleted=false")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance
public class Show extends AbstractPersistable {
    @Column(name = "start_time")
    private LocalDateTime startTime;
    @Column(name = "end_time")
    private LocalDateTime  endTime;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonIgnoreProperties("shows")
    private Movies movies;
    @ManyToOne
    @JoinColumn(name = "screen_id")
    @JsonIgnoreProperties("shows")
    private Screen screen;
    @Column(name = "showStatus")
    private String showStatus;

}
