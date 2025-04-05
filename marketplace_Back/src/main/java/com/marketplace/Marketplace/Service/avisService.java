package com.marketplace.Marketplace.Service;

import com.marketplace.Marketplace.Model.Annonce;
import com.marketplace.Marketplace.Repository.avisRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marketplace.Marketplace.Model.AvisAjout;
import com.marketplace.Marketplace.Service.reponseService;
import java.util.List;
import java.util.Optional;

@Service
public class avisService {
    @Autowired
    private avisRep ar;


    // INSERTION AvisAjout
    public AvisAjout createAvis(AvisAjout avis){
        return ar.save(avis);
    }

    // Retourner la liste des annonces
    public List<AvisAjout> getAllAvis(){
        return ar.findAll();
    }

    // + nblike avis
    public AvisAjout nblikePlus(AvisAjout avis){

        return ar.save(avis);
    }


    // AJOUTER LE NOMBRE DE LIKE DU AVIS
    public AvisAjout updateLikeAvis(Long numavis){
        Optional<AvisAjout> avisTrouve = ar.findById(numavis);
        if (avisTrouve.isPresent()){
            AvisAjout avis = avisTrouve.get();
            // SET NBLIKE
            int nblike = avis.getNblikeavis();
            avis.setNblikeavis(nblike+1);
            return ar.save(avis);
        }
        return null;
    }
    // Diminuer LE NOMBRE DE LIKE DU AVIS
    public AvisAjout updateDislikeAvis(Long numavis){
        Optional<AvisAjout> avisTrouve = ar.findById(numavis);
        if (avisTrouve.isPresent()){
            AvisAjout avis = avisTrouve.get();
            // SET NBLIKE
            int nblike = avis.getNblikeavis();
            if (nblike!=0){
                nblike = nblike - 1;
            }
            avis.setNblikeavis(nblike);
            return ar.save(avis);
        }
        return null;
    }

    // DELETE AVIS ET REPONSE SUR L'AVIS
    public void deleteAvis(Long numavis){

        ar.deleteById(numavis);



    }
}
