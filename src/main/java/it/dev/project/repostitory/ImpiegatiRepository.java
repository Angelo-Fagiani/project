package it.dev.project.repostitory;

import it.dev.project.entities.Impiegati;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpiegatiRepository extends JpaRepository<Impiegati, Long> {


    boolean existsByEmail(String email);
}
