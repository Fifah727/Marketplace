package com.marketplace.Marketplace.Repository;

import com.marketplace.Marketplace.Model.UserAjout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userAjoutRep extends JpaRepository<UserAjout,Long>{
    UserAjout findByEmailu(String email);

    // lite of people whom i talked with in the messages
    //messageenv
    //List<UserAjout> findByMessageenv_IduenvoyeurOrMessagerecep_Idurecepteur(Long iduenvoyeur, Long idurecepteur);
}
