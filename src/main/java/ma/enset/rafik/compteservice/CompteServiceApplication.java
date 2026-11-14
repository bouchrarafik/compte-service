package ma.enset.rafik.compteservice;

import ma.enset.rafik.compteservice.entities.Compte;
import ma.enset.rafik.compteservice.enums.TypeCompte;
import ma.enset.rafik.compteservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class CompteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                Compte compte = Compte.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Math.random() > 0.5 ? TypeCompte.COURANT : TypeCompte.EPARGNE)
                        .solde(10000 + Math.random() * 90000)
                        .dateCreation(new Date())
                        .devise("MAD")
                        .build();
                compteRepository.save(compte);
            }
        };
    }
}
