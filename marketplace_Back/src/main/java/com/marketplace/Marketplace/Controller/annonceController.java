package com.marketplace.Marketplace.Controller;

import com.marketplace.Marketplace.Service.enregService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.marketplace.Marketplace.Service.annonceService;
import com.marketplace.Marketplace.Service.enregService;
import java.util.List;
import com.marketplace.Marketplace.Model.Annonce;
import com.marketplace.Marketplace.Model.AnnonceAjout;
import com.marketplace.Marketplace.Model.PhotoAjout;
import com.marketplace.Marketplace.Model.ProduitAjout;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/annonce")
public class annonceController {
    @Autowired
    private annonceService as;

    @Autowired
    private enregService es;

    // GET ALL : OK
    @GetMapping
    public ResponseEntity<List<Annonce>> getAnnonces(){
        return ResponseEntity.ok(as.getAllAnnonce());
    }

    // GET BY ID : OK
    @GetMapping("/{numa}")
    public ResponseEntity<Annonce> getAnnoncesById(@PathVariable Long numa){
        return ResponseEntity.ok(as.getAnnonceById(numa));
    }

    // INSERT AnnonceAjout : OK
    @PostMapping
    public AnnonceAjout createAnnonce(@RequestBody AnnonceAjout annonce){
        ProduitAjout produit = annonce.getProduit();
        for (PhotoAjout photo : produit.getPhotos()){
            photo.setProduit(produit);
        }
        // sauvagader annonce
        return as.createAnnonce(annonce);
    }
    // DELETE : OK
    @DeleteMapping("/{numa}")
    public void deleteAnnonce(@PathVariable Long numa){
        es.deleteEnregByNuma(numa.intValue());
        as.deleteAnnonce(numa);
    }
    // UPDATE nombre de like : OK
    @PutMapping("/like/{numa}")
    public Annonce updateLikeAnnonce(@PathVariable Long numa){
        return as.updateLikeAnnonce(numa);
    }

    // UPDATE nombre de dislike : OK
    @PutMapping("/dislike/{numa}")
    public Annonce updateDislikeAnnonce(@PathVariable Long numa){
        return as.updateDislikeAnnonce(numa);
    }

    // RECHERCHE PAR NOMPROD : OK
    @GetMapping("/recherche/{nomprod}")
    public ResponseEntity<List<Annonce>> getByNomprod(@PathVariable String nomprod){

        return ResponseEntity.ok(as.getByNomprod(nomprod));

    }
    // RECHERCHE PAR getByCategprog : OK
    @GetMapping("/rechercheCat/{categprod}")
    public ResponseEntity<List<Annonce>> getByCategprog(@PathVariable String categprod){

        return ResponseEntity.ok(as.getByCategprog(categprod));

    }

    // UPDATE
    @PutMapping("/{numa}")
    public ResponseEntity<Annonce> updateAnnonce(
            @PathVariable Long numa,
            @RequestBody Annonce updatedAnnonce) {

        Annonce updated = as.updateAnnonce(numa, updatedAnnonce);
        return ResponseEntity.ok(updated);
    }


}
