package com.linguish.Entity;

import com.linguish.Entity.Enums.Level;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Module {

    @Id
    @Column(name = "module_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moduleId;

    @NotBlank(message = "Este campo es obligatorio")
    @Column(name = "module_name", nullable = false)
    private String moduleName;

    @NotBlank(message = "Este campo es obligatorio")
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "startDate", nullable = false)
    private Date startDate;

    @Column(name = "module_completed_date", nullable = false)
    private Date moduleCompletedDate;

    @Column(name = "Level", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Level> level = new HashSet<>();
    // private Set<Level> level;

    @OneToMany(mappedBy = "module", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Exercises> exercises;

    @OneToMany(mappedBy = "module", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Progress> progressList;

}
