package com.linguish.Entity;

import com.linguish.Enums.Type;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "exercises")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Exercises {

    @Id
    @Column(name = "exerciseId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exerciseId;

    @NotBlank(message = "Este campo es obligatorio")
    @Column(name = "exerciseName", nullable = false)
    private String exerciseName;

    @NotBlank(message = "Este campo es obligatorio")
    @Column(name = "text", nullable = false)
    private String text;

    @NotBlank(message = "Este campo es obligatorio")
    @Column(name = "Keys", nullable = false)
    private ArrayList<?> keys;

    @NotBlank(message = "Este campo es obligatorio")
    @Column(name = "level", nullable = false)
    private Long level;

    @NotBlank(message = "Este campo es obligatorio")
    @Column(name = "exerciseType", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Type> exerciseType = new HashSet<>();

    @NotBlank(message = "Este campo es obligatorio")
    @Column(name = "completed", nullable = false)
    private Boolean completed;

    @Column(name = "completedDate", nullable = false)
    private Date completedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;
}
