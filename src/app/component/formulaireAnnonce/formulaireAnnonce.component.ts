import { NgFor, NgIf } from '@angular/common';
import { Component, NgModule, OnDestroy, OnInit } from '@angular/core';
import { AnnonceService } from '../../service/Annonce.service';
import { ReactiveFormsModule,FormControl, NgForm, FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { SessionService } from './../../service/Session.service';
@Component({
  selector: 'app-formulaireAnnonce',
  imports : [NgFor,NgIf,CommonModule,ReactiveFormsModule,FormsModule],
  templateUrl: './formulaireAnnonce.component.html',
  styleUrls: ['./formulaireAnnonce.component.css']
})
export class FormulaireAnnonceComponent implements OnInit {
  constructor(private apiService: AnnonceService,public sessionService:SessionService) {}

  annonceMaj: any = {
    idu : 0,
    titre: '',
    description: '',
    datecreation: new Date().toISOString().split('T')[0], // Date du jour
    heurecreation: new Date().toLocaleTimeString('fr-FR', { hour12: false }), // Heure actuelle
    statut: 'Disponible',
    nblike: 0,
    produit: {
      codeprod:'',
      nomprod: '',
      prixprod: 100,
      categprod: 'Accessoire',
      taille: 0,
      largeur: 0,
      materiel: '',
      etat: 'Nouveau',
      villeorigine: '',
      descprod: 'Nouveau produit',
      photos: []
    }
  };
  photosMaj = [
    {
      titrephoto : ''
    }
  ];
  ngOnInit() {
    if(this.sessionService.getItem('numaMaj')){
      this.getDataAnnonce();
    }
  }
  numaMaj : boolean = false;
  numa_Maj : number = 0;
  getDataAnnonce(){
    // NON FINISH : SHOW THE IMAGES IN PHOTOS TABLES IN THE FORM MAJ
    this.apiService.getProduit(this.sessionService.getItem('numaMaj')).subscribe(
      (data) =>{
        this.annonceMaj = data;
        this.photosMaj = [...this.annonceMaj.produit.photos];
        this.numa_Maj =this.sessionService.getItem('numaMaj'); 
       this.numaMaj = true; 
       //
       
      //this.loading = false;
      },
      (error) => {
        console.error(error); 
      }
    );
    //this.numaMaj = this.sessionService.getItem('numaMaj');
   
    
  }

  sendAnnonce : boolean = false;

  annonce: any = {
    idu : 0,
    titre: '',
    description: '',
    datecreation: new Date().toISOString().split('T')[0], // Date du jour
    heurecreation: new Date().toLocaleTimeString('fr-FR', { hour12: false }), // Heure actuelle
    statut: 'Disponible',
    nblike: 0,
    produit: {
      nomprod: '',
      prixprod: 100,
      categprod: 'Accessoire',
      taille: 0,
      largeur: 0,
      materiel: '',
      etat: 'Nouveau',
      villeorigine: '',
      descprod: 'Nouveau produit',
      photos: []
    }
  };

  ajouterPhotos(event: any) {
    const fichiers: FileList = event.target.files;

    for (let i = 0; i < fichiers.length; i++) {
      const fichier = fichiers[i];
      const nomComplet = fichier.name; // Nom complet du fichier (avec extension)
      
      // Ajout du nom de la photo dans l'objet annonce
      this.annonce.produit.photos.push({ titrephoto: nomComplet });
    }
  }

  ajouterMajPhotos(event: any) {
    const fichiers: FileList = event.target.files;

    for (let i = 0; i < fichiers.length; i++) {
      const fichier = fichiers[i];
      const nomComplet = fichier.name; // Nom complet du fichier (avec extension)
      
      // Ajout du nom de la photo dans l'objet annonce
      this.photosMaj.push({ titrephoto: nomComplet });
      //this.annonceMaj.produit.photos.push({ titrephoto: nomComplet });
    }
  }

  // Supprimer une image
  removeImage(index: number): void {
    
    this.annonce.produit.photos.splice(index, 1);
  }

  removeMajImage(index: number): void {
    this.photosMaj.splice(index, 1);
    //this.annonceMaj.produit.photos.splice(index, 1);
    //this.annonceMaj.produit.photos.push({ titrephoto: nomComplet });
    
    
  }

// ENVOYER ANNONCE
  message : string = "";
  classeIcon:string="";
  envoyerAnnonce() {
    this.annonce.idu = this.sessionService.getItem('idu');

    const champs = [
      { champ : this.annonce.titre,message:"Le titre de l'annonce est requis."},
      { champ : this.annonce.produit?.nomprod,message:"Le nom du produit est requis."},
      { champ : this.annonce.produit?.villeorigine,message:"La ville d'origine du produit est requis."}
    ]
   
    let erreurs = champs.filter(c=>!c.champ).map(c=>c.message);
    if (erreurs.length>0){
      this.classeIcon = "fa fa-exclamation-triangle text-danger";
      this.message = erreurs.join("<br><br>");
      document.getElementById("btnModal")?.click();
      return;
    }

    this.apiService.createAnnonce(this.annonce).subscribe({
      next: (response) => {
        this.sendAnnonce=true;
        this.classeIcon = "fa fa-check-circle text-success";
        this.message = 'Votre annonce a été publié avec succès ! ';
        const messageModalBtn = document.getElementById("btnModal");
        messageModalBtn?.click();
        setTimeout(()=>{
          window.location.assign("inside/profil");
        },3000);
        
      },
      error: (error) => console.error('Erreur :', error)
    });
  }

  updateAnnonce(){
    this.annonceMaj.produit.photos = [];
    this.annonceMaj.produit.photos = [...this.photosMaj];

    // alert(this.annonceMaj.produit.photos.length);
    this.annonceMaj.idu = this.sessionService.getItem('idu');
    const champs = [
      { champ : this.annonceMaj.titre,message:"Le titre de l'annonce est requis."},
      { champ : this.annonceMaj.produit?.nomprod,message:"Le nom du produit est requis."},
      { champ : this.annonceMaj.produit?.villeorigine,message:"La ville d'origine du produit est requis."}
    ]
   
    let erreurs = champs.filter(c=>!c.champ).map(c=>c.message);
    if (erreurs.length>0){
      this.classeIcon = "fa fa-exclamation-triangle text-danger";
      this.message = erreurs.join("<br><br>");
      document.getElementById("btnModal")?.click();
      return;
    }
    // PRODUIT ET PHOTO NON MAJ : a update dans SPRING BOOT
    this.apiService.updateAnnonce(this.numa_Maj,this.annonceMaj).subscribe({
      next: (response) => {
        this.sendAnnonce=true;
        this.classeIcon = "fa fa-check-circle text-success";
        this.message = 'Votre annonce a été bien modifié';
        const messageModalBtn = document.getElementById("btnModal");
        messageModalBtn?.click();
        this.sessionService.setItem('numa',this.numa_Maj);
        setTimeout(()=>{
          window.location.assign("inside/produitPage");
        },3000);
        console.log(response);
        
        this.sessionService.removeItem('numaMaj');
      },
      error: (error) => console.error('Erreur :', error)
    });
  }
  
// ngOnDestroy(): void {
//   this.sessionService.removeItem('numaMaj');
// }
}
