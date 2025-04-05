package com.marketplace.Marketplace.Controller;

import com.marketplace.Marketplace.Model.Annonce;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.marketplace.Marketplace.Service.produitService;
import java.util.List;
import com.marketplace.Marketplace.Model.Produit;
import com.marketplace.Marketplace.Model.ProduitAjout;
@RestController
@RequestMapping("/produit")
public class produitController {

    @Autowired
    private produitService ps;

    @GetMapping
    public List<Produit> getAll(){
        return ps.getAll();
    }

    // GET BY CODEPROD
    @GetMapping("/{codeprod}")
    public ResponseEntity<Produit> getProduitByCode(@PathVariable Long codeprod){
        return ResponseEntity.ok(ps.getProduitByCode(codeprod));
    }

    // INSERT ProduitAjout
    @PostMapping
    public ProduitAjout createProduit(@RequestBody ProduitAjout ProduitAjout){
        return ps.createProduit(ProduitAjout);
    }

}
