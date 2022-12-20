package it.dev.project.service;

import it.dev.project.entities.Impiegati;
import it.dev.project.payload.request.SignupRequest;
import it.dev.project.repostitory.ImpiegatiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpiegatiService {
    @Autowired
    ImpiegatiRepository impiegatiRepository;

    /*public void create(Impiegati impiegati) {
        Impiegati imp = new Impiegati();
        imp.setNome(impiegati.getNome());
        imp.setCognome(impiegati.getCognome());
        imp.setEmail(impiegati.getEmail());
        imp.setPassword(impiegati.getPassword());
        imp.setBirthday(impiegati.getBirthday());
        impiegatiRepository.save(imp);
   }*/

    /**
     * Metodo per creare un oggetto di tipo impiegato
     */
    public void create(Impiegati impiegati) {
        impiegatiRepository.save(impiegati);
    }

    public boolean existsByEmail(String email) {
        return impiegatiRepository.existsByEmail(email);
    }

    /**
     * Metodo che ritorna una lista di impiegati
     *
     * @return impiegati
     */
    public List<Impiegati> getAllImpiegati() {
        List<Impiegati> impiegati = impiegatiRepository.findAll();
        return impiegati;
    }

    /**
     * Metodo che riceve come parametro un Long matricola
     *
     * @param matricola
     * @return Optional di impiegato
     */
    public Optional<Impiegati> getOneImpiegato(Long matricola) {
        return impiegatiRepository.findById(matricola);
    }

    /*public Impiegati getOne(Long matricola) throws Exception {
        Optional<Impiegati> imp = impiegatiRepository.findById(matricola);
        if (imp.isPresent()) {
            return imp.get();
        } else {
            throw new Exception("Impiegato non trovato");
        }
    }*/

    public Impiegati updateImpiegato(Impiegati impiegati, Long matricola){
        return impiegatiRepository.save(impiegati);
    }
}
