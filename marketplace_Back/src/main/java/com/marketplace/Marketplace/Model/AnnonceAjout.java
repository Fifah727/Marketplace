package com.marketplace.Marketplace.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","enregs"})
@Entity
@Table(name="annonce")
public class AnnonceAjout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numa")
    private Long numa;

    @Column(name="idu")
    private Integer idu;

    @Column(name="titre")
    private String titre;

    @Column(name="description")
    private String description;

    @Column(name="datecreation")
    private LocalDate datecreation;

    @Column(name="heurecreation")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
    private LocalTime heurecreation;

    @Column(name="statut")
    private String statut;

    @Column(name="nblike")
    private Integer nblike;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="codeprod",nullable=false)
    private ProduitAjout produit;

    public AnnonceAjout() {
    }

    public AnnonceAjout(Integer idu, String titre, String description, LocalDate datecreation, LocalTime heurecreation, Integer nblike, String statut, ProduitAjout produit) {
        this.idu = idu;
        this.titre = titre;
        this.description = description;
        this.datecreation = datecreation;
        this.heurecreation = heurecreation;
        this.nblike = nblike;
        this.statut = statut;
        this.produit = produit;
    }

    public Long getNuma() {
        return numa;
    }

    public void setNuma(Long numa) {
        this.numa = numa;
    }

    public Integer getIdu() {
        return idu;
    }

    public void setIdu(Integer idu) {
        this.idu = idu;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(LocalDate datecreation) {
        this.datecreation = datecreation;
    }

    public LocalTime getHeurecreation() {
        return heurecreation;
    }

    public void setHeurecreation(LocalTime heurecreation) {
        this.heurecreation = heurecreation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Integer getNblike() {
        return nblike;
    }

    public void setNblike(Integer nblike) {
        this.nblike = nblike;
    }

    public ProduitAjout getProduit() {
        return produit;
    }

    public void setProduit(ProduitAjout produit) {
        this.produit = produit;
    }
}
