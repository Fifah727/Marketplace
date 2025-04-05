package com.marketplace.Marketplace.Service;

import com.marketplace.Marketplace.Model.Annonce;
import com.marketplace.Marketplace.Model.ReponseAjout;
import com.marketplace.Marketplace.Repository.reponseRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class reponseService {
    @Autowired
    private reponseRep rr;

    public List<ReponseAjout> getAllRep(){
        return rr.findAll();
    }

    // INSERTION AnnonceAjout
    public ReponseAjout createRep(ReponseAjout rep){
        return rr.save(rep);
    }

    // DELETE ALL REPONSE BY NUMAVIS
    public void deleteRep(Integer numavis){
        List<ReponseAjout> rep = rr.findByNumavis(numavis);
        rr.deleteAll(rep);
        //rr.deleteByNumavis(numavis);


    }
    // DELETE  REPONSE
    public void deleteRepById(Long numrep){
        rr.deleteById(numrep);

    }
}
