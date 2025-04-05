package com.marketplace.Marketplace.Service;

import com.marketplace.Marketplace.Model.Annonce;
import com.marketplace.Marketplace.Model.AnnonceAjout;
import com.marketplace.Marketplace.Model.User;
import com.marketplace.Marketplace.Model.UserAjout;
import com.marketplace.Marketplace.Repository.userRep;
import com.marketplace.Marketplace.Repository.userAjoutRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userService {
    @Autowired
    private userRep ur;

    @Autowired
    private userAjoutRep uar;

    public List<User> getAll(){
        return ur.findAll();
    }

    public User getUserById(Long idu){
        return ur.findById(idu).orElse(null);
    }

    // INSERTION user : retourner idu attribué à l'utilisateur
    public Long createUser(UserAjout user){
        uar.save(user);
        return user.getIdu();

    }

    // Rechercher getUserByEmail and MDP
    public UserAjout findByEmail(String email) {
        return uar.findByEmailu(email);
    }

    // AJOUTER UN NOMBRE D'ABONNEES
    public UserAjout updateNbFollower(Long idu){
        Optional<UserAjout> userTrouve = uar.findById(idu);
        if (userTrouve.isPresent()){
            UserAjout user = userTrouve.get();
            // SET NB FOLLOW
            int nbFollower = user.getNbfollower();
            nbFollower = nbFollower + 1;
            user.setNbfollower(nbFollower);
            return uar.save(user);
        }
        return null;
    }

    // DIMINUER UN NOMBRE D'ABONNEES
    public UserAjout updateNbFollowerMoins(Long idu){
        Optional<UserAjout> userTrouve = uar.findById(idu);
        if (userTrouve.isPresent()){
            UserAjout user = userTrouve.get();
            // SET NB FOLLOW
            int nbFollower = user.getNbfollower();
            if (nbFollower!=0){
                nbFollower = nbFollower - 1;
            }
            user.setNbfollower(nbFollower);
            return uar.save(user);
        }
        return null;
    }

    // MAJ USER
    public UserAjout updateUser(UserAjout userDetails,Long idu){
        Optional<UserAjout> userTrouve = uar.findById(idu);
        if (userTrouve.isPresent()){
            UserAjout user = userTrouve.get();

            user.setNomu(userDetails.getNomu());
            user.setPrenomu(userDetails.getPrenomu());
            user.setTelu(userDetails.getTelu());
            user.setEmailu(userDetails.getEmailu());
            user.setAdru(userDetails.getAdru());
            user.setTypeu(userDetails.getTypeu());
            user.setNbfollower(userDetails.getNbfollower());
            user.setPhotou(userDetails.getPhotou());
            user.setMdpu(userDetails.getMdpu());
            user.setIntrou(userDetails.getIntrou());
            user.setImgcouv(userDetails.getImgcouv());


            // set new infos
            return uar.save(user);
        }
        return null;
    }

    //GET USERS AVEC QUI UN USER COMMUNIQUE
    /*public List<UserAjout> getUsersByIdu(Long idu) {
        List<UserAjout> users = uar.findByMessageenv_IduenvoyeurOrMessagerecep_Idurecepteur(idu,idu);
        return users;
    }*/
}
