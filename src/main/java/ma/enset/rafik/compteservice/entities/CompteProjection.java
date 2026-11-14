package ma.enset.rafik.compteservice.entities;

import ma.enset.rafik.compteservice.enums.TypeCompte;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Compte.class, name = "p1")
public interface CompteProjection {
    public String getId();
    public TypeCompte getType();
    public double getSolde();
}
