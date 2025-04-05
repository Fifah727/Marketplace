package com.marketplace.Marketplace.Repository;
import com.marketplace.Marketplace.Model.EnregAjout;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface enregRep extends JpaRepository<EnregAjout,Long>{
    List<EnregAjout> findByNuma(Integer numa);
}
