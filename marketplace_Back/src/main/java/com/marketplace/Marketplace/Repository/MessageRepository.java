package com.marketplace.Marketplace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.marketplace.Marketplace.Model.Message;
import com.marketplace.Marketplace.Model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByUserenvoyeur_IduAndUserrecepteur_Idu(Long iduenvoyeur, Long idurecepteur);
    List<Message> findByUserrecepteur_IduAndUserenvoyeur_Idu(Long idurecepteur, Long iduenvoyeur);

    List<Message> findByUserenvoyeur_IduOrUserrecepteur_Idu(Long iduenvoyeur, Long idurecepteur);
    //List<Message> findByIduenvoyeur(Integer iduenvoyeur);
    //List<Message> findByIduenvoyeurOrIdurecepteur(Integer idu, Integer idu1);
    //List<Message> findByIduenvoyeurOrIdurecepteurAndfindByIduenvoyeurOrIdurecepteur(Integer iduenvoyeur1, Integer iduenvoyeur, Integer idurecepteur1, Integer idurecepteur);
    // message where idrecepteur = you and lu = false
    List<Message> findByUserrecepteur_IduAndLu(Long idurecepteur,boolean islu);

}
