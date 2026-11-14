package ma.enset.rafik.compteservice.repositories;

import ma.enset.rafik.compteservice.entities.Compte;
import ma.enset.rafik.compteservice.enums.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, String> {
    @RestResource(path = "/byType")
    List<Compte> findByType(@Param("t") TypeCompte type);
}
