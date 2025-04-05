package com.marketplace.Marketplace.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="repavis")
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numrep")
    private Long numrep;

    @Column(name="texterep")
    private String texterep;

    @Column(name="date")
    private LocalDate date;

    @Column(name="heure")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
    private LocalTime heure;

    @ManyToOne
    @JoinColumn(name="idu",nullable=false)
    @JsonIgnoreProperties("annonces")
    private User user;

    @ManyToOne
    @JoinColumn(name="numavis",nullable=false)
    //@JsonIgnoreProperties("reponses")
    private Avis avis;

    public Reponse() {
    }

    public Reponse(Long numrep, String texterep, LocalDate date, LocalTime heure) {
        this.numrep = numrep;
        this.texterep = texterep;
        this.date = date;
        this.heure = heure;
    }

    public Reponse(String texterep, LocalDate date, LocalTime heure) {
        this.texterep = texterep;
        this.date = date;
        this.heure = heure;
    }

    public Long getNumrep() {
        return numrep;
    }

    public void setNumrep(Long numrep) {
        this.numrep = numrep;
    }

    public String getTexterep() {
        return texterep;
    }

    public void setTexterep(String texterep) {
        this.texterep = texterep;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

   public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Avis getAvis() {
        return avis;
    }

    public void setAvis(Avis avis) {
        this.avis = avis;
    }
}
