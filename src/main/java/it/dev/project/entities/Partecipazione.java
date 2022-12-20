package it.dev.project.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Partecipazione {

    @EmbeddedId
    private PartecipazioneId partecipazioneId;

    private boolean presente;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partecipazione that = (Partecipazione) o;
        return Objects.equals(partecipazioneId, that.partecipazioneId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partecipazioneId);
    }
}
