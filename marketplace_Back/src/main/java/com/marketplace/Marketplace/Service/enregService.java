package com.marketplace.Marketplace.Service;
import com.marketplace.Marketplace.Model.*;
import com.marketplace.Marketplace.Model.ReponseAjout;
import com.marketplace.Marketplace.Repository.enregRep;
import com.marketplace.Marketplace.Repository.enregRep1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class enregService {
    @Autowired
    private enregRep er;

    @Autowired
    private enregRep1 er1;

    // GET ENREG by idu : avec annonce, user, produit
    public List<Enreg> getEnregByUser(User user){
        return er1.findByUser(user);
    }

    // INSERT EnregAJout
    public EnregAjout newEnreg(EnregAjout enreg){
        return er.save(enreg);
    }

    // DELETE EnregAjout
    public void deleteEnreg(Long numenreg){
        er.deleteById(numenreg);
    }

    // DELETE ALL REPONSE BY NUMA ( quand on delete une annonce, on doit supp tous les enregistrement de cet annonce par all users)
    public void deleteEnregByNuma(Integer numa){
        List<EnregAjout> rep = er.findByNuma(numa);
        er.deleteAll(rep);
    }

}
