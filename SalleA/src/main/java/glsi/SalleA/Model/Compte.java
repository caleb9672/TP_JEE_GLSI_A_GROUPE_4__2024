package glsi.SalleA.Model;

import jakarta.persistence.*;
import org.iban4j.CountryCode;
import org.iban4j.Iban;

import java.util.List;

@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCompte")
    private long idCompte;

    @Column(name = "numeroCompte")
    private  String numeroCompte;

    @Column(name = "montantCompte")
    private double montantCompte;

    @Column(name = "typeCompte")
    private String typeCompte;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client proprietaire;

    @OneToMany(mappedBy = "compteSource")
    private List<Transaction> transactionsSource;

    @OneToMany(mappedBy = "compteDest")
    private List<Transaction> transactionsDest;



    // getters and setters

    public long getIdCompte() {
        return idCompte;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }
    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public void getNumeroCompte(String numero) {
        this.numeroCompte = numeroCompte;
    }

    public double getMontantCompte() {
        return montantCompte;
    }
    public void setMontantCompte(double montantCompte) {
        this.montantCompte = montantCompte;
    }

    public String getTypeCompte() {
        return typeCompte;
    }
    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public void setProprietaire(Client proprietaire) {
        this.proprietaire = proprietaire;
    }
    public Client getProprietaire() {
        return proprietaire;
    }

    // Constructeur
    public Compte(String typeCompte, Client proprietaire) {
        this.typeCompte = typeCompte;
        this.proprietaire = proprietaire;

        // Générer le numéro de compte automatiquement
        this.numeroCompte = generateNumeroCompte();
    }

    public Compte(){
        // Générer le numéro de compte automatiquement
        this.numeroCompte = generateNumeroCompte();
    }

    private String generateNumeroCompte() {
        // Construire un IBAN avec le code du pays (par exemple, FR pour la France)
        Iban iban = Iban.random(CountryCode.FR);

        // Retourner le numéro de compte généré
        return iban.toString();
    }
}
