package glsi.SalleA.Model;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTransaction")
    private long idTransaction;

    @Column(name = "montant")
    private double montant;

    @Column(name = "typeTransaction")
    private String typeTransaction;  // Dépôt, Retrait, Virement, etc.

    @Column(name = "dateTransaction")
    private Date dateTransaction;

    @ManyToOne
    @JoinColumn(name = "compteSource_id")
    private Compte compteSource;

    @ManyToOne
    @JoinColumn(name = "compteDest_id")
    private Compte compteDest;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Transaction() {
        this.dateTransaction = new Date();  // La date par défaut est la date actuelle lors de la création de la transaction.
    }

    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }
    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public Compte getCompteSource() {
        return compteSource;
    }
    public void setCompteSource(Compte compteSource) {
        this.compteSource = compteSource;
    }

    public Compte getCompteDest() {
        return compteDest;
    }
    public void setCompteDest(Compte compteDest) {
        this.compteDest = compteDest;
    }

    // Getters and Setters
}
