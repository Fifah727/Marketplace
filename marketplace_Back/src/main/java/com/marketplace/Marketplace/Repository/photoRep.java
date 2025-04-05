package com.marketplace.Marketplace.Repository;

import com.marketplace.Marketplace.Model.Photo;
import com.marketplace.Marketplace.Model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface photoRep extends JpaRepository<Photo,Long>{
   void deleteByProduit(Produit produit);
}
