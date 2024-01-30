package glsi.SalleA.Service;

import glsi.SalleA.Model.Compte;
import glsi.SalleA.Model.Client;
import glsi.SalleA.Model.Transaction;
import glsi.SalleA.Service.TransactionService;
import glsi.SalleA.Repository.CompteRepository;
import glsi.SalleA.Repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompteService {
    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private TransactionRepository transactionRepository;

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


    public Compte createCompte(String typeCompte, Client proprietaire) {
        Compte compte = new Compte();
        compte.setTypeCompte(typeCompte);
        compte.setProprietaire(proprietaire);
        // Autres initialisations
        return compteRepository.save(compte);
    }

    public void deleteCompteById(Long idCompte) {
        // Vérifier si le client existe avant de le supprimer
        if (compteRepository.existsById(idCompte)) {
            compteRepository.deleteById(idCompte);
        } else {
            throw new EntityNotFoundException("Client not found with id: " + idCompte);
        }
    }

    public void deposer(long idCompte, double montant) {
        Compte compte = compteRepository.findById(idCompte)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé"));

        compte.setMontantCompte(compte.getMontantCompte() + montant);
        compteRepository.save(compte);

        creerTransaction(compte, montant, "Depot");
    }

    public void retirer(long idCompte, double montant) {
        Compte compte = compteRepository.findById(idCompte)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé"));

        if (compte.getMontantCompte() < montant) {
            throw new RuntimeException("Solde insuffisant");
        }

        compte.setMontantCompte(compte.getMontantCompte() - montant);
        compteRepository.save(compte);

        creerTransaction(compte, montant, "Retrait");
    }

    public void effectuerVirement(long idCompteSourceId, long idCompteDest, double montant) {
        Compte compteSource = compteRepository.findById(idCompteSourceId)
                .orElseThrow(() -> new RuntimeException("Compte source non trouvé"));

        Compte compteDest = compteRepository.findById(idCompteDest)
                .orElseThrow(() -> new RuntimeException("Compte destination non trouvé"));

        if (compteSource.getMontantCompte() < montant) {
            throw new RuntimeException("Solde insuffisant sur le compte source");
        }

        compteSource.setMontantCompte(compteSource.getMontantCompte() - montant);
        compteDest.setMontantCompte(compteDest.getMontantCompte() + montant);

        compteRepository.save(compteSource);
        compteRepository.save(compteDest);

        creerTransaction(compteSource, compteDest, montant, "Retrait");
    }


    private void creerTransaction(Compte compte, double montant, String typeTransaction) {
        Transaction transaction = new Transaction();
        transaction.setMontant(montant);
        transaction.setTypeTransaction(typeTransaction);
        transaction.setCompteSource(compte);
        transactionRepository.save(transaction);
    }

    private void creerTransaction(Compte compteSource, Compte compteDest, double montant, String typeTransaction) {
        Transaction transaction = new Transaction();
        transaction.setMontant(montant);
        transaction.setTypeTransaction(typeTransaction);
        transaction.setCompteSource(compteSource);
        transaction.setCompteDest(compteDest);
        transactionRepository.save(transaction);
    }

}