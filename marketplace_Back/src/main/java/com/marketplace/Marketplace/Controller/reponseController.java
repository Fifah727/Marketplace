package com.marketplace.Marketplace.Controller;

import com.marketplace.Marketplace.Model.AvisAjout;
import com.marketplace.Marketplace.Model.ReponseAjout;
import com.marketplace.Marketplace.Model.PhotoAjout;
import com.marketplace.Marketplace.Model.ProduitAjout;
import com.marketplace.Marketplace.Service.reponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reponse")
public class reponseController {

    @Autowired
    private reponseService rs;

    // GET ALL
    @GetMapping
    public ResponseEntity<List<ReponseAjout>> getRep(){
        return ResponseEntity.ok(rs.getAllRep());
    }

    // INSERT ReponseAjout
    @PostMapping
    public ReponseAjout createRep(@RequestBody ReponseAjout rep){
        return rs.createRep(rep);
    }

    // DELETE AVIS
    @DeleteMapping("/{numavis}")
    public void deleteAvis(@PathVariable Integer numavis){
        rs.deleteRep(numavis);
    }

    // DELETE REPONSE
    @DeleteMapping("/id/{numrep}")
    public void deleteRep(@PathVariable Long numrep){
        rs.deleteRepById(numrep);
    }

}
