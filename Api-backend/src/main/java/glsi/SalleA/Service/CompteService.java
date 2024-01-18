package glsi.SalleA.Service;

import glsi.SalleA.Model.Compte;
import glsi.SalleA.Model.Client;
import glsi.SalleA.Repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompteService {
    @Autowired
    private CompteRepository compteRepository;

    public List<Compte> getAllComptes(){
        return compteRepository.findAll();
    }
    public Compte getCompteById(long IdCompte) {
        return compteRepository.findById(IdCompte).orElse(null);
    }

    // méthodes pour gérer les opérations sur les comptes
    public List<Compte> getComptesByClientId(long IdClient) {
        return compteRepository.findByProprietaireId(IdClient);
    }


    public Compte createCompte(String numeroCompte, Client proprietaire) {
        Compte compte = new Compte();
        compte.setNumeroCompte(numeroCompte);
        compte.setProprietaire(proprietaire);
        // Autres initialisations
        return compteRepository.save(compte);
    }

}