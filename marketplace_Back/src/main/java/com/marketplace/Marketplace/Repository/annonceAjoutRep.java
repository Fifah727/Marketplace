package com.marketplace.Marketplace.Repository;

import com.marketplace.Marketplace.Model.AnnonceAjout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface annonceAjoutRep extends JpaRepository<AnnonceAjout,Long>{

}
