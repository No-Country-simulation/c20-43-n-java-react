package com.linguish.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Progress {

    @Id
    @Column(name = "progress_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long progressId;

    // Relación con el usuario que está progresando
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Relación con el módulo en el que el usuario está progresando
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;

    // Porcentaje de progreso en el módulo (0.0 a 100.0)
    @Column(name = "percentage_completed", nullable = false)
    private Double percentageCompleted;

    // Booleano para indicar si el módulo ha sido completado
    @Column(name = "is_completed", nullable = false)
    private Boolean isCompleted;

    // Fecha de la última actualización de progreso
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated", nullable = false)
    private Date lastUpdated;

    public void updateProgress(double newPercentage) {
        this.percentageCompleted = newPercentage;
        if (newPercentage >= 100.0) {
            this.isCompleted = true;
        }
        this.lastUpdated = new Date();
    }
}
