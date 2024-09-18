package com.linguish.Entity;

import jakarta.persistence.*;
import lombok.*;

<<<<<<< HEAD
import java.util.Date;
=======
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
>>>>>>> ecf9aa84f0b9346f8305c310dde50ba4117aa2e4

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @Column(name = "user_name")
    private String username;

    private String password;

    private String email;

    private Date registerDate;
=======
    private String username;

    private String email;

    private String password;

    @CreatedDate
    private LocalDateTime registerDate;
>>>>>>> ecf9aa84f0b9346f8305c310dde50ba4117aa2e4

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Progress> progressList = new ArrayList<>();


}
