package com.linguish.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity (name = "proggress")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Progress {

    @Id
    @Column(name = "progressId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long progressId;

    // Relación con el usuario que está progresando
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    // Relación con el módulo en el que el usuario está progresando
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moduleId", nullable = false)
    private Module module;

    // Porcentaje de progreso en el módulo (0.0 a 100.0)
    @Column(name = "percentageCompleted", nullable = false)
    private Double percentageCompleted;

    // Booleano para indicar si el módulo ha sido completado
    @Column(name = "isCompleted", nullable = false)
    private Boolean isCompleted;

    // Fecha de la última actualización de progreso
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastUpdated", nullable = false)
    private Date lastUpdated;

    public void updateProgress(double newPercentage) {
        this.percentageCompleted = newPercentage;
        if (newPercentage >= 100.0) {
            this.isCompleted = true;
        }
        this.lastUpdated = new Date();
    }
}
