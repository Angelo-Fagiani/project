package it.dev.project.controller;

import it.dev.project.entities.Impiegati;
import it.dev.project.payload.request.SignupRequest;
import it.dev.project.service.ImpiegatiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/impiegato")
public class ImpiegatiController {

    @Autowired
    ImpiegatiService impiegatiService;

    @Autowired
    PasswordEncoder passwordEncoder;

    /*@PutMapping("/registrazione")
    public ResponseEntity<?> registraImpiegato(@RequestBody SignupRequest signupRequest) {
        impiegatiService.create(signupRequest);
        return new ResponseEntity<>("Created",HttpStatus.CREATED);
        }*/

    @PutMapping("/create")
    public ResponseEntity<?> createImpiegato(@RequestBody SignupRequest signupRequest) {
        if (impiegatiService.existsByEmail(signupRequest.getEmail())) {
            return new ResponseEntity<>("email already exists", HttpStatus.BAD_REQUEST);
        }

        Impiegati imp = new Impiegati(
                signupRequest.getNome(),
                signupRequest.getCognome(),
                signupRequest.getEmail(),
                passwordEncoder.encode(signupRequest.getPassword()),
                signupRequest.getBirthday()
        );
        impiegatiService.create(imp);
        return new ResponseEntity<Impiegati>(imp, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllImpiegati() {
        List<Impiegati> imp = impiegatiService.getAllImpiegati();
        return new ResponseEntity<>(imp, HttpStatus.OK);
    }

    @GetMapping("/{matricola}")
    public ResponseEntity<?> getOneImpiegato(@PathVariable Long matricola) {
        Optional<Impiegati> imp = impiegatiService.getOneImpiegato(matricola);
        return new ResponseEntity<>(imp, HttpStatus.OK);
    }

    

}

