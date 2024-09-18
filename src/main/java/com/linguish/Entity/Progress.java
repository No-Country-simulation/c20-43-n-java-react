package com.linguish.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "progress")
@EntityListeners(AuditingEntityListener.class)
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double percentageCompleted;
    
    private Boolean isCompleted;

    @Transient
    private Long moduleId;

    @Transient
    private Long userId;

    @LastModifiedDate
    private Date lastUpdated;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne()
    @JoinColumn(name = "module_id")
    @JsonIgnore
    private Module module;

}

