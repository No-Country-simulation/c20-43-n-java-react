package com.linguish.Entity;

import com.linguish.Enums.Level;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "module")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Module {

    @Id
    @Column(name = "moduleId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moduleId;

    @NotBlank(message = "Este campo es obligatorio")
    @Column(name = "moduleName", nullable = false)
    private String moduleName;

    @NotBlank(message = "Este campo es obligatorio")
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "startDate", nullable = false)
    private Date startDate;

    @Column(name = "moduleCompletedDate", nullable = false)
    private Date moduleCompletedDate;

    @NotNull(message = "Este campo es obligatorio")
    @Column(name = "Level", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Level> level = new HashSet<>();

    @OneToMany(mappedBy = "module", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Exercises> exercises;

    @OneToMany(mappedBy = "module", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Progress> progressList;
}
