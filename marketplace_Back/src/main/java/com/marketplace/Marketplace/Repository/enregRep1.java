package com.marketplace.Marketplace.Repository;

import com.marketplace.Marketplace.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface enregRep1 extends JpaRepository<Enreg,Long>{

    //List<Enreg> findByIdu(Integer idu);
    List<Enreg> findByUser(User user);
        //List<User> user = findById(Long idu);



}
