package com.marketplace.Marketplace.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="repavis")
public class ReponseAjout {
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

    @Column(name="idu")
    private Integer idu;

    @Column(name="numavis")
    private Integer numavis;



    public ReponseAjout() {
    }

    public ReponseAjout(Long numrep, String texterep, LocalDate date, LocalTime heure) {
        this.numrep = numrep;
        this.texterep = texterep;
        this.date = date;
        this.heure = heure;
    }

    public ReponseAjout(String texterep, LocalDate date, LocalTime heure) {
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

    public Integer getIdu() {
        return idu;
    }

    public void setIdu(Integer idu) {
        this.idu = idu;
    }

    public Integer getNumavis() {
        return numavis;
    }

    public void setNumavis(Integer numavis) {
        this.numavis = numavis;
    }
}
