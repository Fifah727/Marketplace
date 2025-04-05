package com.marketplace.Marketplace.Repository;
import com.marketplace.Marketplace.Model.Annonce;

import com.marketplace.Marketplace.Model.Enreg;
import com.marketplace.Marketplace.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface annonceRep extends JpaRepository<Annonce,Long>{
    // RECHERCHE PAR NOM PRODUIT : ex: casque
    // chercher toutes annonces de tous produits avec nomprod = "casque"
    List<Annonce> findByProduit_NomprodContainingIgnoreCaseOrderByNblikeDesc(String nomprod);
    List<Annonce> findByProduit_CategprodIgnoreCaseOrderByNblikeDesc(String nomprod);

    List<Annonce> findAllByOrderByNblikeDesc();

}
