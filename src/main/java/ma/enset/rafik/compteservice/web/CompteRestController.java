package ma.enset.rafik.compteservice.web;

import ma.enset.rafik.compteservice.dto.CompteRequestDTO;
import ma.enset.rafik.compteservice.dto.CompteResponseDTO;
import ma.enset.rafik.compteservice.entities.Compte;
import ma.enset.rafik.compteservice.mappers.CompteMapper;
import ma.enset.rafik.compteservice.repositories.CompteRepository;
import ma.enset.rafik.compteservice.service.CompteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompteRestController {
    private CompteRepository compteRepository;
    private CompteService compteService;
    private CompteMapper compteMapper;

    public CompteRestController(CompteRepository compteRepository, CompteService compteService, CompteMapper compteMapper) {
        this.compteRepository = compteRepository;
        this.compteService = compteService;
        this.compteMapper = compteMapper;
    }

    @GetMapping("/comptes")
    public List<Compte> comptes() {
        return compteRepository.findAll();
    }

    @GetMapping("/comptes/{id}")
    public Compte compte(@PathVariable String id) {
        return compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Compte %s not found", id)));
    }

    @PostMapping("/comptes")
    public CompteResponseDTO save(@RequestBody CompteRequestDTO requestDTO) {
        return compteService.addCompte(requestDTO);
    }

    @PutMapping("/comptes/{id}")
    public CompteResponseDTO update(@PathVariable String id, @RequestBody CompteRequestDTO requestDTO) {
        return compteService.updateCompte(id, requestDTO);
    }

    @DeleteMapping("/comptes/{id}")
    public void deleteCompte(@PathVariable String id) {
        compteRepository.deleteById(id);
    }
}
