package com.marketplace.Marketplace.Controller;

import com.marketplace.Marketplace.Model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.marketplace.Marketplace.Service.userService;
import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private userService us;

    @GetMapping
    public List<User> getAnnonce(){return us.getAll();
    }
    // GET BY ID : OK
    @GetMapping("/{idu}")
    public ResponseEntity<User> getUserById(@PathVariable Long idu){
        return ResponseEntity.ok(us.getUserById(idu));
    }

    // INSERT User : retourner l'id attribué à l'user : OK (a update : si email doesn't exist yet)
    @PostMapping
    public  ResponseEntity<?> createUser(@RequestBody UserAjout user){

        UserAjout userExiste = us.findByEmail(user.getEmailu());

        if (userExiste!=null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email déjà utilisé");
        }else{
            return ResponseEntity.ok(us.createUser(user));
        }


    }

    // GET BY EMAIL AND MDP : OK
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        UserAjout user = us.findByEmail(loginRequest.getEmail());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utilisateur non trouvé");
        } else if (!user.getMdpu().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Mot de passe incorrect");
        }
        else {
            return ResponseEntity.ok(user.getIdu());  // Retourne seulement l'ID si la connexion est réussie
        }

    }

    // UPDATE NB FOLLOWER USER
    @PutMapping("/follow/{idu}")
    public UserAjout updateNbFollower(@PathVariable Long idu){
        return us.updateNbFollower(idu);
    }

    // UPDATE NB FOLLOWER USER
    @PutMapping("/nofollow/{idu}")
    public UserAjout updateNbFollowerMoins(@PathVariable Long idu){
        return us.updateNbFollowerMoins(idu);
    }

    // UPDATE USER
    @PutMapping("/{idu}")
    public UserAjout updateUser(@RequestBody UserAjout user, @PathVariable Long idu){

        return us.updateUser(user,idu);
    }


    // GET LIST OF PEOPLE IN MY MESSAGE
    /*@GetMapping("/convWithUsers/{idu}")
    public ResponseEntity<List<UserAjout>> getUsersByIdu(@PathVariable Long idu) {
        List<UserAjout> users = us.getUsersByIdu(idu);
        return ResponseEntity.ok(users);
    }*/
}
