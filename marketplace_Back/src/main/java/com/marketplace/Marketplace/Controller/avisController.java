package com.marketplace.Marketplace.Controller;

import com.marketplace.Marketplace.Model.Annonce;
import com.marketplace.Marketplace.Service.reponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.marketplace.Marketplace.Service.avisService;
import com.marketplace.Marketplace.Model.AvisAjout;

import java.util.List;

@RestController
@RequestMapping("/avis")
public class avisController {

    @Autowired
    private avisService as;

    @Autowired
    private reponseService rs;


    // GET ALL
    @GetMapping
    public ResponseEntity<List<AvisAjout>> getAvis(){
        return ResponseEntity.ok(as.getAllAvis());
    }

    @PostMapping
    public AvisAjout insertAvis(@RequestBody AvisAjout avis){return as.createAvis(avis);}


    // UPDATE nombre de like
    @PutMapping("/like/{numavis}")
    public AvisAjout updateLikeAvis(@PathVariable Long numavis){
        return as.updateLikeAvis(numavis);
    }

    // UPDATE nombre de dislike
    @PutMapping("/dislike/{numavis}")
    public AvisAjout updateDislikeAvis(@PathVariable Long numavis){
        return as.updateDislikeAvis(numavis);
    }

    // DELETE AVIS
    @DeleteMapping("/{numavis}")
    public void deleteAvis(@PathVariable Long numavis){
        rs.deleteRep(numavis.intValue());
        as.deleteAvis(numavis);
    }

}
