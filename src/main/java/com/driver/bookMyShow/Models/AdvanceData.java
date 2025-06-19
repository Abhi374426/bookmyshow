package com.driver.bookMyShow.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "advance_data", uniqueConstraints = {
        @UniqueConstraint(name = "unique_advance", columnNames = {
                "date", "advance_type", "vechicle_type", "route_name", "status", "vendor"
        })
})
public class AdvanceData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "advance_type")
    private String advanceType;

    @Column(name = "vechicle_type")
    private String vechicleType;

    @Column(name = "route_name")
    private String routeName;

    private String status;

    private String vendor;

    private Double amount;

    private String action;

    @Column(name = "user_id_creation", nullable = false)
    private Long userIdCreation;

    @Column(name = "user_id_updation", nullable = false)
    private Long userIdUpdation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updation_date")
    private Date updationDate;
}
