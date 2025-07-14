package com.rhis.rhisoftware.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stagiaires")
public class Stagiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String prenom;
    private String nom;
    private String email;
    private String programme_formation;
    private java.sql.Date date_debut;
    private java.sql.Date date_fin;
    private String statut;

    // Constructeur vide requis par JPA
    public Stagiaire() {}

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getProgramme_formation() { return programme_formation; }
    public void setProgramme_formation(String programme_formation) { this.programme_formation = programme_formation; }
    public java.sql.Date getDate_debut() { return date_debut; }
    public void setDate_debut(java.sql.Date date_debut) { this.date_debut = date_debut; }
    public java.sql.Date getDate_fin() { return date_fin; }
    public void setDate_fin(java.sql.Date date_fin) { this.date_fin = date_fin; }
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}