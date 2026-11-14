package ma.enset.rafik.compteservice.service;

import jakarta.transaction.Transactional;
import ma.enset.rafik.compteservice.dto.CompteRequestDTO;
import ma.enset.rafik.compteservice.dto.CompteResponseDTO;
import ma.enset.rafik.compteservice.entities.Compte;
import ma.enset.rafik.compteservice.mappers.CompteMapper;
import ma.enset.rafik.compteservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class CompteServiceImpl implements CompteService {
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private CompteMapper compteMapper;

    @Override
    public CompteResponseDTO addCompte(CompteRequestDTO compteDTO) {
        Compte compte = Compte.builder()
                .id(UUID.randomUUID().toString())
                .dateCreation(new Date())
                .solde(compteDTO.getSolde())
                .type(compteDTO.getType())
                .devise(compteDTO.getDevise())
                .build();
        Compte savedCompte = compteRepository.save(compte);
        CompteResponseDTO compteResponseDTO = compteMapper.fromCompte(savedCompte);
        return compteResponseDTO;
    }

    @Override
    public CompteResponseDTO updateCompte(String id, CompteRequestDTO compteDTO) {
        Compte compte = Compte.builder()
                .id(id)
                .dateCreation(new Date())
                .solde(compteDTO.getSolde())
                .type(compteDTO.getType())
                .devise(compteDTO.getDevise())
                .build();
        Compte savedCompte = compteRepository.save(compte);
        CompteResponseDTO compteResponseDTO = compteMapper.fromCompte(savedCompte);
        return compteResponseDTO;
    }
}
