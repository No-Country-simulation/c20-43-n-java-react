package com.linguish.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "Este campo es obligatorio")
    @Column(name = "name", nullable = false)
    private String userName;

    @NotBlank(message = "Este campo es obligatorio")
    @Email(message = "Formato de email incorrecto")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Este campo es obligatorio")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$", message = "Mínimo seis caracteres , una mayúscula y un número")
    @Column(name = "password", nullable = false)
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(name = "register_date")
    private Date registerDate;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Progress> progressList;

}
