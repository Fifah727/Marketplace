package com.marketplace.Marketplace.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="enreg")
public class Enreg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numenreg")
    private Long numenreg;

    @Column(name="dateenreg")
    private LocalDate dateenreg;

    /*@Column(name="idu")
    private Integer idu;*/

    @ManyToOne
    @JoinColumn(name="idu",nullable=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","enregs","annonces"})
    private User user;

    @ManyToOne
    @JoinColumn(name="numa",nullable=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","enregs"})
    private Annonce annonce;

    public Enreg() {}

    public Enreg(Long numenreg, LocalDate dateenreg) {
        this.numenreg = numenreg;
        this.dateenreg = dateenreg;
    }

    public Enreg(LocalDate dateenreg) {this.dateenreg = dateenreg;}

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

    /*public Integer getIdu() {
        return idu;
    }

    public void setIdu(Integer idu) {
        this.idu = idu;
    }*/

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
