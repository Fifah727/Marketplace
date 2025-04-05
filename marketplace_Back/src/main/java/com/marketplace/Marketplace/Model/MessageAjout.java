package com.marketplace.Marketplace.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "message")
public class MessageAjout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmessage")
    private Long idmessage;

    /*@ManyToOne
    @JoinColumn(name="iduenvoyeur",nullable=false)
    private User userEnvoyeur;*/

     /*@ManyToOne
    @JoinColumn(name="idurecepteur",nullable=false)
    private User userRecepteur;*/

    @Column(name="iduenvoyeur")
    private Integer iduenvoyeur;

    @Column(name="idurecepteur")
    private Integer idurecepteur;

    @Column(name="texte")
    private String texte;

    @Column(name="date")
    private LocalDate date;

    @Column(name="heure")
    private LocalTime heure;

    @Column(name="lu")
    private boolean lu = false;

    // Getters et setters

    public Long getIdmessage() {
        return idmessage;
    }

    public void setIdmessage(Long idmessage) {
        this.idmessage = idmessage;
    }

    public Integer getIduenvoyeur() {
        return iduenvoyeur;
    }

    public void setIduenvoyeur(Integer iduenvoyeur) {
        this.iduenvoyeur = iduenvoyeur;
    }

    public Integer getIdurecepteur() {
        return idurecepteur;
    }

    public void setIdurecepteur(Integer idurecepteur) {
        this.idurecepteur = idurecepteur;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isLu() {
        return lu;
    }

    public void setLu(boolean lu) {
        this.lu = lu;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }
}