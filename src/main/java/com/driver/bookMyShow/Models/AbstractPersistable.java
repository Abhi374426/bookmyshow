package com.driver.bookMyShow.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class  AbstractPersistable {

    @Column(name = "ID")
    @Id
    private String id;

    @Column(name = "CREATED_AT")
    @CreationTimestamp
    private LocalDateTime createdAt;

//    @Column(name = "CREATED_BY")
//    private User createdBy;
//
//    @Column(name = "CREATED_BY")
//    private User updatedBy;

    @Column(name = "UPDATED_AT")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "IS_DELETED", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean deleted = Boolean.FALSE;

    @Column(name = "IS_ACTIVE", columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean isActive = Boolean.TRUE;
}
