package com.marketplace.Marketplace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.marketplace.Marketplace.Model.Message;
import com.marketplace.Marketplace.Model.MessageAjout;
import com.marketplace.Marketplace.Model.User;
import org.springframework.stereotype.Repository;


@Repository
public interface MessageAjoutRepository extends JpaRepository<MessageAjout, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM MessageAjout m WHERE (m.iduenvoyeur= :val1 AND m.idurecepteur= :val2) OR (m.iduenvoyeur= :val2 AND m.idurecepteur= :val1)")
    void deleteByEnvAndRec(@Param("val1") Integer val1, @Param("val2") Integer val2);
}
