package com.marketplace.Marketplace.Controller;

import com.marketplace.Marketplace.Model.*;

import com.marketplace.Marketplace.Service.enregService;
import com.marketplace.Marketplace.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enreg")
public class enregController {
    @Autowired
    private enregService es;

    @Autowired
    private userService us;
    // OK
    @GetMapping("/{idu}")
    public ResponseEntity<List<Enreg>> getEnregs(@PathVariable Long idu){
        User userTrouve = us.getUserById(idu);
        return ResponseEntity.ok(es.getEnregByUser(userTrouve));
    }

    // INSERT EnregAjout
    @PostMapping
    public EnregAjout createEnreg(@RequestBody EnregAjout enreg){
        return es.newEnreg(enreg);
    }


    // DELETE EnregAjout
    @DeleteMapping("/{numenreg}")
    public void deleteEnreg(@PathVariable Long numenreg){
        es.deleteEnreg(numenreg);
    }

}
