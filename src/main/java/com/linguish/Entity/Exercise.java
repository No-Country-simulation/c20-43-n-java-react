package com.linguish.Entity;

import com.linguish.Entity.Enums.Type;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String text;

    // private List<String> keys = new ArrayList<>();

    private Long level;

    // private List<Type> exerciseType = new ArrayList();

    private Boolean completed;
    private Date completedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
    private Module module;
    
}

