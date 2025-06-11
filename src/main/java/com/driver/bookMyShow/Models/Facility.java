package com.driver.bookMyShow.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "FACILITY")
@Setter
@Getter
@SQLDelete(sql="UPDATE FACILITY SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Facility extends AbstractPersistable{
    @Column(name = "FACILITY_NAME")
    private String  facility;
    @Column(name = "LOGO")
    private String  logo;


}
