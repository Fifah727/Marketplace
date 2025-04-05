package com.marketplace.Marketplace.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","enregs"})
@Entity
@Table(name="utilisateur")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idu")
    private Long idu;

    @Column(name="nomu")
    private String nomu;

    @Column(name="prenomu")
    private String prenomu;

    @Column(name="telu")
    private String telu;

    @Column(name="emailu")
    private String emailu;

    @Column(name="adru")
    private String adru;

    @Column(name="typeu")
    private String typeu;

    @Column(name="nbfollower")
    private Integer nbfollower;

    @Column(name="dateinscri")
    private LocalDate dateinscri;

    @Column(name="photou")
    private String photou;

    @Column(name="mdpu")
    private String mdpu;

    @Column(name="introu")
    private String introu;

    @Column(name="imgcouv")
    private String imgcouv;

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonIgnoreProperties("user")
    private List<Annonce> annonces;

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonIgnoreProperties("user")
    private List<Enreg> enregs;

    /*@OneToMany(mappedBy = "user",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    //@JsonIgnoreProperties("user")
    private List<Avis> avis;*/

    /*@OneToMany(mappedBy = "user",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonIgnoreProperties("user")
    private List<Reponse> reponses;*/

    public User() {
    }

    public User(Long idu, String nomu, String prenomu, String telu, String emailu, String adru, String typeu, Integer nbfollower, LocalDate dateinscri, String photou, String mdpu, String introu, String imgcouv) {
        this.idu = idu;
        this.nomu = nomu;
        this.prenomu = prenomu;
        this.telu = telu;
        this.emailu = emailu;
        this.adru = adru;
        this.typeu = typeu;
        this.nbfollower = nbfollower;
        this.dateinscri = dateinscri;
        this.photou = photou;
        this.mdpu = mdpu;
        this.introu = introu;
        this.imgcouv = imgcouv;
    }

    public User(String nomu, String prenomu, String telu, String emailu, String adru, String typeu, Integer nbfollower, LocalDate dateinscri, String photou, String mdpu, String introu, String imgcouv) {
        this.nomu = nomu;
        this.prenomu = prenomu;
        this.telu = telu;
        this.emailu = emailu;
        this.adru = adru;
        this.typeu = typeu;
        this.nbfollower = nbfollower;
        this.dateinscri = dateinscri;
        this.photou = photou;
        this.mdpu = mdpu;
        this.introu = introu;
        this.imgcouv = imgcouv;
    }

    public Long getIdu() {
        return idu;
    }

    public void setIdu(Long idu) {
        this.idu = idu;
    }

    public String getNomu() {
        return nomu;
    }

    public void setNomu(String nomu) {
        this.nomu = nomu;
    }

    public String getPrenomu() {
        return prenomu;
    }

    public void setPrenomu(String prenomu) {
        this.prenomu = prenomu;
    }

    public String getTelu() {
        return telu;
    }

    public void setTelu(String telu) {
        this.telu = telu;
    }

    public String getEmailu() {
        return emailu;
    }

    public void setEmailu(String emailu) {
        this.emailu = emailu;
    }

    public String getAdru() {
        return adru;
    }

    public void setAdru(String adru) {
        this.adru = adru;
    }

    public String getTypeu() {
        return typeu;
    }

    public void setTypeu(String typeu) {
        this.typeu = typeu;
    }

    public Integer getNbfollower() {
        return nbfollower;
    }

    public void setNbfollower(Integer nbfollower) {
        this.nbfollower = nbfollower;
    }

    public LocalDate getDateinscri() {
        return dateinscri;
    }

    public void setDateinscri(LocalDate dateinscri) {
        this.dateinscri = dateinscri;
    }

    public String getPhotou() {
        return photou;
    }

    public void setPhotou(String photou) {
        this.photou = photou;
    }

    public String getMdpu() {
        return mdpu;
    }

    public void setMdpu(String mdpu) {
        this.mdpu = mdpu;
    }

    public String getIntrou() {
        return introu;
    }

    public void setIntrou(String introu) {
        this.introu = introu;
    }

    public String getImgcouv() {
        return imgcouv;
    }

    public void setImgcouv(String imgcouv) {
        this.imgcouv = imgcouv;
    }

    public List<Annonce> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }

   public List<Enreg> getEnregs() {
        return enregs;
    }

   public void setEnregs(List<Enreg> enregs) {
        this.enregs = enregs;
    }


    /*public List<Avis> getAvis() {
        return avis;
    }

    public void setAvis(List<Avis> avis) {
        this.avis = avis;
    }*/


/*
    public List<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(List<Reponse> reponses) {
        this.reponses = reponses;
    }*/
}
