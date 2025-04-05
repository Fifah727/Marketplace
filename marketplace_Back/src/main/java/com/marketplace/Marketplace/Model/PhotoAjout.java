package com.marketplace.Marketplace.Model;
import jakarta.persistence.*;

@Entity
@Table(name="photo")
public class PhotoAjout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idphoto")
    private Long idphoto;

    @Column(name="titrephoto")
    private String titrephoto;

    @ManyToOne
    @JoinColumn(name="codeprod")
    private ProduitAjout produit;

    public PhotoAjout() {
    }

    public PhotoAjout(Long idphoto, String titrephoto) {
        this.idphoto = idphoto;
        this.titrephoto = titrephoto;


    }

    public PhotoAjout(String titrephoto) {
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

    public ProduitAjout getProduit() {
        return produit;
    }

    public void setProduit(ProduitAjout produit) {
        this.produit = produit;
    }
}
