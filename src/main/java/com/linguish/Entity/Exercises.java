package com.linguish.Entity;

import com.linguish.Entity.Enums.Type;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Exercises {

    @Id
    @Column(name = "exercise_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exerciseId;

    @NotBlank(message = "Este campo es obligatorio")
    @Column(name = "exercise_name", nullable = false)
    private String exerciseName;

    @NotBlank(message = "Este campo es obligatorio")
    @Column(name = "text", nullable = false)
    private String text;

    @NotBlank(message = "Este campo es obligatorio")
    @Column(name = "Keys", nullable = false)
    private List<String> keys = new ArrayList<>();

    @Column(name = "level", nullable = false)
    private Long level;

    @NotBlank(message = "Este campo es obligatorio")
    @Column(name = "exerciseType", nullable = false)
    private Set<Type> exerciseType = new HashSet<>();

    @Column(name = "completed", nullable = false)
    private Boolean completed;

    @Column(name = "completedDate", nullable = false)
    private Date completedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;
}

