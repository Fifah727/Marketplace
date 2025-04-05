package com.marketplace.Marketplace.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idphoto")
    private Long idphoto;

    @Column(name="titrephoto")
    private String titrephoto;

    @ManyToOne
    @JoinColumn(name="codeprod")
    private Produit produit;

    public Photo() {
    }

    public Photo(Long idphoto, String titrephoto) {
        this.idphoto = idphoto;
        this.titrephoto = titrephoto;


    }

    public Photo(String titrephoto) {
        this.titrephoto = titrephoto;

    }

    public Long getIdphoto() {
        return idphoto;
    }

    public void setIdphoto(Long idphoto) {
        this.idphoto = idphoto;
    }

    public String getTitrephoto() {
        return titrephoto;
    }

    public void setTitrephoto(String titrephoto) {
        this.titrephoto = titrephoto;
    }


    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
