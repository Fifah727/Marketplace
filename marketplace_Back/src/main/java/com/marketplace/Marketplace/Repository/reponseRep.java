package com.marketplace.Marketplace.Repository;

import com.marketplace.Marketplace.Model.ReponseAjout;
import com.marketplace.Marketplace.Model.UserAjout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface reponseRep extends JpaRepository<ReponseAjout,Long>{

    List<ReponseAjout> findByNumavis(Integer numavis);
    void deleteByNumavis(Integer numavis);

}
