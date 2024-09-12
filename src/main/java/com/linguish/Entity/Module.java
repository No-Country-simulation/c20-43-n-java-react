package com.linguish.Entity;

import com.linguish.Entity.Enums.Level;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "modules")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Date startDate;

    private Date moduleCompletedDate;

    // private List<Level> level = new ArrayList<>();

    // @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "module")
    // @JsonManagedReference
    // private List<Exercise> exercises;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "progress_id")
    private List<Progress> progress;

}

