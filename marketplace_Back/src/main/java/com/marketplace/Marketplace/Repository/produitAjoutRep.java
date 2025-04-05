package com.marketplace.Marketplace.Repository;

import com.marketplace.Marketplace.Model.ProduitAjout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface produitAjoutRep extends JpaRepository<ProduitAjout,Long>{



}
