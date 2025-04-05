package com.marketplace.Marketplace.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;
@Entity
@Table(name="produit")
public class ProduitAjout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codeprod")
    private Long codeprod;

    @Column(name="nomprod")
    private String nomprod;

    @Column(name="prixprod")
    private float prixprod;

    @Column(name="categprod")
    private String categprod;

    @Column(name="taille")
    private float taille;

    @Column(name="hauteur")
    private float hauteur;

    @Column(name="largeur")
    private float largeur;

    @Column(name="materiel")
    private String materiel;

    @Column(name="etat")
    private String etat;

    @Column(name="villeorigine")
    private String villeorigine;

    @Column(name="descprod")
    private String descprod;

    @OneToMany(mappedBy = "produit",cascade=CascadeType.ALL, orphanRemoval=true)
    @JsonIgnoreProperties("produit")
    private List<PhotoAjout> photos = new ArrayList<>();

    public void addPhoto(PhotoAjout photo){
        photo.setProduit(this);
        this.photos.add(photo);
    }

    public ProduitAjout() {
    }

    public ProduitAjout(Long codeprod, String nomprod, float prixprod, String categprod, float taille, float hauteur, float largeur, String materiel, String etat, String villeorigine, String descprod) {
        this.codeprod = codeprod;
        this.nomprod = nomprod;
        this.prixprod = prixprod;
        this.categprod = categprod;
        this.taille = taille;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.materiel = materiel;
        this.etat = etat;
        this.villeorigine = villeorigine;
        this.descprod = descprod;
    }

    public ProduitAjout(String nomprod, float prixprod, String categprod, float taille, float hauteur, float largeur, String materiel, String etat, String villeorigine, String descprod) {
        this.nomprod = nomprod;
        this.prixprod = prixprod;
        this.categprod = categprod;
        this.taille = taille;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.materiel = materiel;
        this.etat = etat;
        this.villeorigine = villeorigine;
        this.descprod = descprod;
    }

    public Long getCodeprod() {
        return codeprod;
    }

    public void setCodeprod(Long codeprod) {
        this.codeprod = codeprod;
    }

    public String getNomprod() {
        return nomprod;
    }

    public void setNomprod(String nomprod) {
        this.nomprod = nomprod;
    }

    public float getPrixprod() {
        return prixprod;
    }

    public void setPrixprod(float prixprod) {
        this.prixprod = prixprod;
    }

    public String getCategprod() {
        return categprod;
    }

    public void setCategprod(String categprod) {
        this.categprod = categprod;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public float getHauteur() {
        return hauteur;
    }

    public void setHauteur(float hauteur) {
        this.hauteur = hauteur;
    }

    public float getLargeur() {
        return largeur;
    }

    public void setLargeur(float largeur) {
        this.largeur = largeur;
    }

    public String getMateriel() {
        return materiel;
    }

    public void setMateriel(String materiel) {
        this.materiel = materiel;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getVilleorigine() {
        return villeorigine;
    }

    public void setVilleorigine(String villeorigine) {
        this.villeorigine = villeorigine;
    }

    public String getDescprod() {return descprod;}

    public void setDescprod(String descprod) {this.descprod = descprod;}

    public List<PhotoAjout> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoAjout> photos) {
        this.photos = photos;
    }
}

