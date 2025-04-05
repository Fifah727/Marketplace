package com.marketplace.Marketplace.Model;
import jakarta.persistence.*;
import com.marketplace.Marketplace.Model.Annonce;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","annonces"})
@Entity
@Table(name="produit")
public class Produit {
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

    @OneToMany(mappedBy = "produit",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    // @JsonIgnoreProperties("produit") // ne pas ignorer produit dans annonce
    private List<Annonce> annonces;

    @OneToMany(mappedBy = "produit",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonIgnoreProperties("produit")
    private List<Photo> photos;

    @OneToMany(mappedBy = "produit",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonIgnoreProperties("produit")
    private List<Avis> avis;

    public Produit() {
    }

    public Produit(Long codeprod, String nomprod, float prixprod, String categprod, float taille, float hauteur, float largeur, String materiel, String etat, String villeorigine,String descprod) {
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

    public Produit(String nomprod, float prixprod, String categprod, float taille, float hauteur, float largeur, String materiel, String etat, String villeorigine,String descprod) {
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

    public List<Annonce> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Avis> getAvis() {
        return avis;
    }

    public void setAvis(List<Avis> avis) {
        this.avis = avis;
    }
}

