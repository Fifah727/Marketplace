package com.marketplace.Marketplace.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="avis")
public class AvisAjout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numavis")
    private Long numavis;

    @Column(name="commentaire")
    private String commentaire;

    @Column(name="dateavis")
    private LocalDate dateavis;

    @Column(name="idu")
    private Integer idu;

    @Column(name="noteavis")
    private float noteavis;

    @Column(name="codeprod")
    private Integer codeprod;

    @Column(name="nblikeavis")
    private Integer nblikeavis;

    public AvisAjout() {
    }

    public AvisAjout(Long numavis, String commentaire, LocalDate dateavis, Integer idu, float noteavis, Integer codeprod, Integer nblikeavis) {
        this.numavis = numavis;
        this.commentaire = commentaire;
        this.dateavis = dateavis;
        this.idu = idu;
        this.noteavis = noteavis;
        this.codeprod = codeprod;
        this.nblikeavis = nblikeavis;
    }

    public AvisAjout(String commentaire, LocalDate dateavis, Integer idu, float noteavis, Integer codeprod, Integer nblikeavis) {
        this.commentaire = commentaire;
        this.dateavis = dateavis;
        this.idu = idu;
        this.noteavis = noteavis;
        this.codeprod = codeprod;
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

    public Integer getIdu() {
        return idu;
    }

    public void setIdu(Integer idu) {
        this.idu = idu;
    }

    public float getNoteavis() {
        return noteavis;
    }

    public void setNoteavis(float noteavis) {
        this.noteavis = noteavis;
    }

    public Integer getCodeprod() {
        return codeprod;
    }

    public void setCodeprod(Integer codeprod) {
        this.codeprod = codeprod;
    }

    public Integer getNblikeavis() {
        return nblikeavis;
    }

    public void setNblikeavis(Integer nblikeavis) {
        this.nblikeavis = nblikeavis;
    }
}
