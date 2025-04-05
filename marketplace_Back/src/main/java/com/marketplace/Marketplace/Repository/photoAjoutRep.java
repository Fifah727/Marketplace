package com.marketplace.Marketplace.Repository;

import com.marketplace.Marketplace.Model.PhotoAjout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface photoAjoutRep extends JpaRepository<PhotoAjout,Long>{

}
