package ma.enset.rafik.compteservice.mappers;

import ma.enset.rafik.compteservice.dto.CompteRequestDTO;
import ma.enset.rafik.compteservice.dto.CompteResponseDTO;
import ma.enset.rafik.compteservice.entities.Compte;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CompteMapper {
    public CompteResponseDTO fromCompte(Compte compte) {
        CompteResponseDTO compteResponseDTO = new CompteResponseDTO();
        BeanUtils.copyProperties(compte, compteResponseDTO);
        return compteResponseDTO;
    }

    public Compte toCompte(CompteRequestDTO requestDTO) {
        Compte compte = new Compte();
        BeanUtils.copyProperties(requestDTO, compte);
        return compte;
    }
}
