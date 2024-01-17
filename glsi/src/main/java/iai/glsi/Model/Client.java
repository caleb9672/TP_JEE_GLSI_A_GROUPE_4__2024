package iai.glsi.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClient")
    private long idClient;

    // autres champs
    @Column(name = "name")
    private String name;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "description")
    private String description;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "sexe")
    private String sexe;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "dateNaissance")
    private java.util.Date dateNaissance;
    @Column(name = "courriel")
    private String courriel;

    @Column(name = "nationalite")
    private String nationalite;

    @OneToMany(mappedBy = "proprietaire")
    private List<Compte> comptes;

    public Client() {
    }

    // getters et setters

    public long getIdClient() {
        return idClient;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getSexe() {
        return sexe;
    }
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public java.util.Date getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public String getCourriel() {
        return courriel;
    }
    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }
    public String getNationalite() {
        return nationalite;
    }
    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

}