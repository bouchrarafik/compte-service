package ma.enset.rafik.compteservice.service;

import ma.enset.rafik.compteservice.dto.CompteRequestDTO;
import ma.enset.rafik.compteservice.dto.CompteResponseDTO;

public interface CompteService {
    CompteResponseDTO addCompte(CompteRequestDTO compteDTO);
    CompteResponseDTO updateCompte(String id, CompteRequestDTO compteDTO);
}
