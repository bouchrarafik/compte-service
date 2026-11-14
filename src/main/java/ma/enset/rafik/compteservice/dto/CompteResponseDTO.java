package ma.enset.rafik.compteservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.rafik.compteservice.enums.TypeCompte;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CompteResponseDTO {
    private String id;
    private Date dateCreation;
    private double solde;
    private String devise;
    private TypeCompte type;
}
