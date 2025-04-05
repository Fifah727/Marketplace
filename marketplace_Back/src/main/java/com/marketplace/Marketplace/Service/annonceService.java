package com.marketplace.Marketplace.Service;
import com.marketplace.Marketplace.Model.*;
import com.marketplace.Marketplace.Service.*;
import com.marketplace.Marketplace.Repository.*;
//import com.marketplace.Marketplace.Repository.annonceRep;
//import com.marketplace.Marketplace.Repository.annonceAjoutRep;
//import com.marketplace.Marketplace.Service.produitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class annonceService {
    @Autowired
    private annonceRep ar;

    @Autowired
    private produitService ps;

    @Autowired
    private annonceAjoutRep aar;

    @Autowired
    private produitRep pr;

    @Autowired
    private photoRep phr;

    // Retourner la liste des annonces
    public List<Annonce> getAllAnnonce(){
        return ar.findAllByOrderByNblikeDesc();
    }

    // GET BY ID
    public Annonce getAnnonceById(Long numa){
        return ar.findById(numa).orElse(null);
    }

    // MODIFICATION
    public Annonce updateAnnonce(Long numa, Annonce updatedAnnonce) {
        Annonce annonce = ar.findById(numa)
                .orElseThrow(() -> new RuntimeException("Annonce non trouvée"));

        // Mise à jour du titre de l'annonce
        annonce.setTitre(updatedAnnonce.getTitre());
        annonce.setDescription(updatedAnnonce.getDescription());
        annonce.setDatecreation(updatedAnnonce.getDatecreation());
        annonce.setHeurecreation(updatedAnnonce.getHeurecreation());
        annonce.setStatut(updatedAnnonce.getStatut());
        annonce.setNblike(updatedAnnonce.getNblike());
//        annonce.setProduit(updatedAnnonce.getProduit());
//        annonce.setUser(updatedAnnonce.getUser());

        // Mise à jour du produit
        Produit produit = annonce.getProduit();
        if (produit == null) {
            produit = new Produit();
        }

        produit.setNomprod(updatedAnnonce.getProduit().getNomprod());
        produit.setPrixprod(updatedAnnonce.getProduit().getPrixprod());
        produit.setCategprod(updatedAnnonce.getProduit().getCategprod());
        produit.setTaille(updatedAnnonce.getProduit().getTaille());
        produit.setHauteur(updatedAnnonce.getProduit().getHauteur());
        produit.setLargeur(updatedAnnonce.getProduit().getLargeur());
        produit.setMateriel(updatedAnnonce.getProduit().getMateriel());
        produit.setEtat(updatedAnnonce.getProduit().getEtat());
        produit.setVilleorigine(updatedAnnonce.getProduit().getVilleorigine());
        produit.setDescprod(updatedAnnonce.getProduit().getDescprod());

        // Mise à jour des photos
        List<Photo> newPhotos = updatedAnnonce.getProduit().getPhotos();

//        List<Photo> photoAncienne = produit.getPhotos();
        phr.deleteByProduit(produit);
        if (newPhotos != null) {
            //produit.getPhotos().clear();
            // Supprime les anciennes photos
            for (Photo photo : newPhotos) {
                photo.setProduit(produit);
                produit.getPhotos().add(photo);
            }
        }

        // Sauvegarde
        pr.save(produit);
        annonce.setProduit(produit);
        return ar.save(annonce);
    }

    /*public Annonce updateAnnonce(Long numa,Annonce annonceDetails){
        // annonce
        Optional<Annonce> annonceTrouve = ar.findById(numa);
        Optional<ProduitAjout> produitTrouve = ar.findById(getCodeprod);

        if (annonceTrouve.isPresent()){
            Annonce annonce = annonceTrouve.get();
            ProduitAjout produit = produitTrouve.get();

            // SET
            annonce.setTitre(annonceDetails.getTitre());
            annonce.setDescription(annonceDetails.getDescription());
            annonce.setDatecreation(annonceDetails.getDatecreation());
            annonce.setHeurecreation(annonceDetails.getHeurecreation());
            annonce.setStatut(annonceDetails.getStatut());
            annonce.setNblike(annonceDetails.getNblike());
            annonce.setProduit(annonceDetails.getProduit());
            annonce.setUser(annonceDetails.getUser());

          produit.setNomprod = nomprod;
           produit.setPrixprod = prixprod;
           produit.setCategprod = categprod;
            produit.setTaille = taille;
            produit.setHauteur = hauteur;
            produit.setLargeur = largeur;
            produit.setMateriel = materiel;
            produit.setEtat = etat;
            produit.setVilleorigine = villeorigine;
            produit.setDescprod = descprod;



            // produit // NON FINISH

            if (annonceTrouve.isPresent()){
                ProduitAjout produit = produitTrouve.get();
                // SET
                annonce.setTitre(annonceDetails.getTitre());
                annonce.setDescription(annonceDetails.getDescription());

                return  ps.createProduit(ProduitAjout);
            }
            return ar.save(annonce);
        }
        return null;
    }*/
    // AJOUTER LE NOMBRE DE LIKE DU ANNONCE
    public Annonce updateLikeAnnonce(Long numa){
        Optional<Annonce> annonceTrouve = ar.findById(numa);
        if (annonceTrouve.isPresent()){
            Annonce annonce = annonceTrouve.get();
            // SET NBLIKE
            int nblike = annonce.getNblike();
            annonce.setNblike(nblike+1);
            return ar.save(annonce);
        }
        return null;
    }
    // Diminuer LE NOMBRE DE LIKE DU ANNONCE
    public Annonce updateDislikeAnnonce(Long numa){
        Optional<Annonce> annonceTrouve = ar.findById(numa);
        if (annonceTrouve.isPresent()){
            Annonce annonce = annonceTrouve.get();
            // SET NBLIKE
            int nblike = annonce.getNblike();
            if (nblike!=0){
                nblike = nblike - 1;
            }
            annonce.setNblike(nblike);
            return ar.save(annonce);
        }
        return null;
    }

    // INSERTION AnnonceAjout
    public AnnonceAjout createAnnonce(AnnonceAjout annonce){
        return aar.save(annonce);
    }
    // DELETE
    public void deleteAnnonce(Long numa){
        ar.deleteById(numa);
    }

    // RECHERCHE annonce par nomprod
    public List<Annonce> getByNomprod(String nomprod){
        return ar.findByProduit_NomprodContainingIgnoreCaseOrderByNblikeDesc(nomprod);
    }

    // RECHERCHE annonce par nomprod
    public List<Annonce> getByCategprog(String categprod){
        return ar.findByProduit_CategprodIgnoreCaseOrderByNblikeDesc(categprod);
    }

}
