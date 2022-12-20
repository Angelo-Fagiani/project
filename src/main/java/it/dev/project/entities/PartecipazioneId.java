package it.dev.project.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PartecipazioneId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Impiegati_matricola", nullable = false)
    private Impiegati impiegati;

    @ManyToOne
    @JoinColumn(name = "Progetti_id", nullable = false)
    private Progetti progetti;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartecipazioneId that = (PartecipazioneId) o;
        return Objects.equals(impiegati, that.impiegati) && Objects.equals(progetti, that.progetti);
    }

    @Override
    public int hashCode() {
        return Objects.hash(impiegati, progetti);
    }
}
