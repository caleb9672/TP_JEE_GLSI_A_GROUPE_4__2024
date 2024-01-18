package glsi.SalleA.Model;

import jakarta.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client proprietaire;

    // Constructeur

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

    public void setProprietaire(Client proprietaire) {
        this.proprietaire = proprietaire;
    }
    public Client getProprietaire() {
        return proprietaire;
    }
}
