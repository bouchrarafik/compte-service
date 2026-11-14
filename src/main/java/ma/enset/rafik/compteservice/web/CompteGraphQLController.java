package ma.enset.rafik.compteservice.web;

import ma.enset.rafik.compteservice.dto.CompteRequestDTO;
import ma.enset.rafik.compteservice.dto.CompteResponseDTO;
import ma.enset.rafik.compteservice.entities.Compte;
import ma.enset.rafik.compteservice.repositories.CompteRepository;
import ma.enset.rafik.compteservice.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CompteGraphQLController {
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private CompteService compteService;

    @QueryMapping
    public List<Compte> comptesList() {
        return compteRepository.findAll();
    }

    @QueryMapping
    public Compte compteById(@Argument String id) {
        return compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Compte %s not found", id)));
    }

    @MutationMapping
    public CompteResponseDTO addCompte(@Argument CompteRequestDTO compte) {
        return compteService.addCompte(compte);
    }

    @MutationMapping
    public CompteResponseDTO updateCompte(@Argument String id, @Argument CompteRequestDTO compte) {
        return compteService.updateCompte(id, compte);
    }

    @MutationMapping
    public Boolean deleteCompte(@Argument String id) {
        compteRepository.deleteById(id);
        return true;
    }
}
