package it.dev.project.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Impiegati {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricola;

    //@Column(nullable = false, length = 30)
    private String nome;

   // @Column(nullable = false, length = 30)
    private String cognome;

   //@Column(nullable = false, unique = true)
    private String email;

    //Column(nullable = false)
    //@Size(min = 8)
    private String password;

    @Column(nullable = false)
    private LocalDate birthday;

    public Impiegati(String nome, String cognome, String email, String password, LocalDate birthday) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
    }



}


