package com.marketplace.Marketplace.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.marketplace.Marketplace.Model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface produitRep extends JpaRepository<Produit,Long>{

    /*@Query("SELECT p FROM produit p JOIN annonce a ON p.codeprod=a.produit.codeprod WHERE a.numa = :numa")
    Produit findByNuma(Long numa);*/

}
