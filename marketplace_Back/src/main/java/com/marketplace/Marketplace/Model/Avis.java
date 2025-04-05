package com.marketplace.Marketplace.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name="avis")
public class Avis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numavis")
    private Long numavis;

    @Column(name="commentaire")
    private String commentaire;

    @Column(name="dateavis")
    private LocalDate dateavis;

    @ManyToOne
    @JoinColumn(name="idu",nullable=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","annonces"})//
    private User user;

    @Column(name="noteavis")
    private float noteavis;

    @ManyToOne
    @JoinColumn(name="codeprod",nullable=false)
    //@JsonIgnoreProperties("avis")
    private Produit produit;

    @Column(name="nblikeavis")
    private Integer nblikeavis;

    @OneToMany(mappedBy = "avis",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonIgnoreProperties("avis")
    private List<Reponse> reponses;

    public Avis() {
    }

    public Avis(Long numavis, String commentaire, LocalDate dateavis, float noteavis, Integer nblikeavis) {
        this.numavis = numavis;
        this.commentaire = commentaire;
        this.dateavis = dateavis;
        this.noteavis = noteavis;
        this.nblikeavis = nblikeavis;
    }

    public Avis(String commentaire, LocalDate dateavis, float noteavis, Integer nblikeavis) {
        this.commentaire = commentaire;
        this.dateavis = dateavis;
        this.noteavis = noteavis;
        this.nblikeavis = nblikeavis;
    }

    public Long getNumavis() {
        return numavis;
    }

    public void setNumavis(Long numavis) {
        this.numavis = numavis;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public LocalDate getDateavis() {
        return dateavis;
    }

    public void setDateavis(LocalDate dateavis) {
        this.dateavis = dateavis;
    }


    public float getNoteavis() {
        return noteavis;
    }

    public void setNoteavis(float noteavis) {
        this.noteavis = noteavis;
    }


    public Integer getNblikeavis() {
        return nblikeavis;
    }

    public void setNblikeavis(Integer nblikeavis) {
        this.nblikeavis = nblikeavis;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }


    public List<Reponse> getReponses() {
        return reponses;
    }
    public void setReponses(List<Reponse> reponses) {
        this.reponses = reponses;
    }

}
