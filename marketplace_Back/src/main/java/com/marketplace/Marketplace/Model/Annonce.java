package com.marketplace.Marketplace.Model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","enregs"})
@Entity
@Table(name="annonce")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numa")
    private Long numa;

    @ManyToOne
    @JoinColumn(name="idu",nullable=false)
    @JsonIgnoreProperties("annonces")
    private User user;

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

    @ManyToOne
    @JoinColumn(name="codeprod",nullable=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})//annonces//
    private Produit produit;

    @OneToMany(mappedBy = "annonce",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonIgnoreProperties("annonce")
    private List<Enreg> enregs;

    public Annonce() {
    }

    public Annonce(Long numa, User user, String titre, String description, LocalDate datecreation, LocalTime heurecreation, String statut, Integer nblike, Produit produit, List<Enreg> enregs) {
        this.numa = numa;
        this.user = user;
        this.titre = titre;
        this.description = description;
        this.datecreation = datecreation;
        this.heurecreation = heurecreation;
        this.statut = statut;
        this.nblike = nblike;
        this.produit = produit;
        this.enregs = enregs;
    }

    public Annonce(User user, String titre, String description, LocalDate datecreation, LocalTime heurecreation, String statut, Integer nblike, Produit produit, List<Enreg> enregs) {
        this.user = user;
        this.titre = titre;
        this.description = description;
        this.datecreation = datecreation;
        this.heurecreation = heurecreation;
        this.statut = statut;
        this.nblike = nblike;
        this.produit = produit;
        this.enregs = enregs;
    }

    public Long getNuma() {
        return numa;
    }

    public void setNuma(Long numa) {
        this.numa = numa;
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

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Enreg> getEnregs() {
        return enregs;
    }

    public void setEnregs(List<Enreg> enregs) {
        this.enregs = enregs;
    }
}
