package it.dev.project.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ImpiegatoRequest {


    private String nome;


    private String cognome;


    @Email
    private String email;


    private String password;


    private LocalDate birthday;

    public ImpiegatoRequest(String nome, String cognome, String password, LocalDate birthday) {
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        this.birthday = birthday;
    }
}
