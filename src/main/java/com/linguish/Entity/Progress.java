package com.linguish.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "progress")
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double percentageCompleted;
    
    private Boolean isCompleted;

    private Date lastUpdated;

    @ManyToOne()
    // @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;

    public void updateProgress(double newPercentage) {
        this.percentageCompleted = newPercentage;
        if (newPercentage >= 100.0) {
            this.isCompleted = true;
        }
        this.lastUpdated = new Date();
    }
}

