package com.linguish.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.linguish.Entity.Enums.Type;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private String answers;
    
    private Boolean completed;

    @Transient
    private Long moduleId;

    @ElementCollection()
    @Enumerated(EnumType.STRING)
    private List<Type> exerciseType;

    @ManyToOne()
    @JoinColumn(name = "module_id")
    @JsonIgnore
    private Module module;

}

