package ma.enset.rafik.compteservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.rafik.compteservice.enums.TypeCompte;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CompteRequestDTO {
    private double solde;
    private String devise;
    private TypeCompte type;
}
