package com.marketplace.Marketplace.Service;
import com.marketplace.Marketplace.Model.Annonce;
import com.marketplace.Marketplace.Model.Produit;
import com.marketplace.Marketplace.Model.ProduitAjout;
import com.marketplace.Marketplace.Repository.produitRep;
import com.marketplace.Marketplace.Repository.produitAjoutRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class produitService {
    @Autowired
    private produitRep pr;

    @Autowired
    private produitAjoutRep pra;

    public List<Produit> getAll(){
        return pr.findAll();
    }


    // FIND BY CODEPROD
    public Produit getProduitByCode(Long codeprod){
        return pr.findById(codeprod).orElse(null);

    }

    // INSERTION ProduitAjout model
    public ProduitAjout createProduit(ProduitAjout ProduitAjout){
        return pra.save(ProduitAjout);
    }
}
