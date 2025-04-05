package com.marketplace.Marketplace.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name="enreg")
public class EnregAjout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numenreg")
    private Long numenreg;

    @Column(name="dateenreg")
    private LocalDate dateenreg;

    @Column(name="idu")
    private Integer idu;

    @Column(name="numa")
    private Integer numa;

    public EnregAjout() {}

    public EnregAjout(Long numenreg, LocalDate dateenreg, Integer idu, Integer numa) {
        this.numenreg = numenreg;
        this.dateenreg = dateenreg;
        this.idu = idu;
        this.numa = numa;
    }

    public EnregAjout(LocalDate dateenreg, Integer idu, Integer numa) {
        this.dateenreg = dateenreg;
        this.idu = idu;
        this.numa = numa;
    }

    public Long getNumenreg() {
        return numenreg;
    }

    public void setNumenreg(Long numenreg) {
        this.numenreg = numenreg;
    }

    public LocalDate getDateenreg() {
        return dateenreg;
    }

    public void setDateenreg(LocalDate dateenreg) {
        this.dateenreg = dateenreg;
    }

    public Integer getIdu() {
        return idu;
    }

    public void setIdu(Integer idu) {
        this.idu = idu;
    }

    public Integer getNuma() {
        return numa;
    }

    public void setNuma(Integer numa) {
        this.numa = numa;
    }
}
