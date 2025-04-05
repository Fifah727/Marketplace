package com.marketplace.Marketplace.Model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmessage")
    private Long idmessage;

    @ManyToOne
    @JoinColumn(name="iduenvoyeur",nullable=false)
    //@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})//annonces//
    private UserAjout userenvoyeur;

    @ManyToOne
    @JoinColumn(name="idurecepteur",nullable=false)
    //@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})//annonces//
    private UserAjout userrecepteur;

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

    public UserAjout getUserenvoyeur() {
        return userenvoyeur;
    }

    public void setUserenvoyeur(UserAjout userenvoyeur) {
        this.userenvoyeur = userenvoyeur;
    }

    public UserAjout getUserrecepteur() {
        return userrecepteur;
    }

    public void setUserrecepteur(UserAjout userrecepteur) {
        this.userrecepteur = userrecepteur;
    }
}