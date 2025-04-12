import { SessionService } from './../../service/Session.service';
import { Component, NgModule, OnInit } from '@angular/core';
import { NgForm, NgModel } from '@angular/forms';
import { UtilisateurService } from '../../service/Utilisateur.service';
import { ReactiveFormsModule,FormControl, FormsModule } from '@angular/forms';
import { CommonModule, NgIf } from '@angular/common';
import { AnnonceService } from '../../service/Annonce.service';

@Component({
  selector: 'app-signin',
  imports:[CommonModule,CommonModule,ReactiveFormsModule,FormsModule],
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  constructor(private apiService: UtilisateurService,
    private sessionService:SessionService,
    private serviceA:AnnonceService,) {}

  sendUser : boolean = false;
  idUser : string = "";

  
  photo:string="pasImage.png";
  photoCouv:string="couv.jpg";


  // CHARGER LES INFOS MAJ
  userMajInfos: any = {
    idu : '',
    nomu:'',
    prenomu:'',
    telu:'',
    emailu:'',
    adru:'',
    typeu:'',
    dateinscri: '',
    nbfollower:0,
    photou:'',
    mdpu:'',
    introu:'',
    imgcouv:''
  };
  iduMaj : boolean = false;
  ngOnInit() {
    if (this.sessionService.getItem('iduMaj')){
      // Charger les donnees à mettre à jour
      this.iduMaj = true;
      this.apiService.getData(this.sessionService.getItem('iduMaj')).subscribe(
        (data) =>{
          this.userMajInfos = data;
          this.photo = this.userMajInfos.photou;
          this.photoCouv = this.userMajInfos.imgcouv;
        },
        (error) => {
          console.error(error);
        }
      );
      this.sessionService.removeItem('iduMaj');
    }
  }
  
  // METTRE a jour les infos de l'user
  majUser() {

    if (this.userMajInfos.emailu!=""){
      if(this.photo!=""){
      this.userMajInfos.photou = this.photo;
      }
      if(this.photoCouv!=""){
        this.userMajInfos.imgcouv = this.photoCouv;
      }
      

      this.userMajInfos.idu = this.sessionService.getItem('idu');
      
      this.apiService.updateUser(this.userMajInfos,this.sessionService.getItem('idu')).subscribe({
        next: (response) =>  {
          console.log('Données envoyées :', response);
          // pour message "Vous etes enregistré"
          this.idUser = response;
          // this.message= "Votre compte a été crée avec succès! Numéro de compte :"+response;
          // const messageModalBtn = document.getElementById("btnModal");
          // messageModalBtn?.click();
          // Stocker l'id de l'utilisateur
          //this.sessionService.setItem('idu',response);
          window.location.assign("inside/profil");
        },
        error: (error) => console.error('Erreur :', error)   
      });
    }

    else{
      this.message = "Vous devez fournir une adresse email valide ! ";
      const messageModalBtn = document.getElementById("btnModal");
      messageModalBtn?.click();
      
    }
   
  }


  
  user: any = {
    nomu:'New',
    prenomu:'user',
    telu:'',
    emailu:'',
    adru:'',
    typeu:'Acheteur',
    dateinscri: new Date().toISOString().split('T')[0], // Date du jour
    nbfollower:0,
    photou:'',
    mdpu:'',
    introu:'',
    imgcouv:''
  };


  ajouterPhotos(event: any) {
    const fichiers: FileList = event.target.files;

    for (let i = 0; i < fichiers.length; i++) {
      const fichier = fichiers[i];
      const nomComplet = fichier.name; // Nom complet du fichier (avec extension)
      
      // Ajout du nom de la photo dans l'objet user
      this.photo = nomComplet ;
      this.user.photou = nomComplet;

    }
  }
  ajouterPhotosCouv(event: any) {
    const fichiers: FileList = event.target.files;

    for (let i = 0; i < fichiers.length; i++) {
      const fichier = fichiers[i];
      const nomComplet = fichier.name; // Nom complet du fichier (avec extension)
      
      // Ajout du nom de la photo dans l'objet user
      this.photoCouv = nomComplet ;
      this.user.imgcouv = nomComplet;

    }
  }
 
  fileImage(){
    const fileInput = document.getElementById("photosPdp");
    fileInput?.click();
  }

  fileImageCouv(){
    const fileInput = document.getElementById("photosCouv");
    fileInput?.click();
  }


  message : string = "";
  // ENVOYER user
  envoyerUser() {

    if (this.user.emailu!=""){
      if (this.user.photou == ""){
        this.user.photou ="pasImage.png";
      }
      if (this.user.imgcouv == ""){
        this.user.imgcouv = "couv.jpg";
      }
      this.apiService.createUser(this.user).subscribe({
        next: (response) =>  {
          
          console.log('Données envoyées :', response);
          // pour message "Vous etes enregistré"
          this.sendUser = true;
          this.idUser = response;
          this.message= "Votre compte a été crée avec succès! Numéro de compte :"+response;
          const messageModalBtn = document.getElementById("btnModal");
          messageModalBtn?.click();
          // Stocker l'id de l'utilisateur
          this.sessionService.setItem('idu',response);
          setTimeout(()=>{
            window.location.assign("login");
          },3000);

        },
        error: (error) => {
          this.message= error;
          const messageModalBtn = document.getElementById("btnModal");
          messageModalBtn?.click();
        }
      });
    }

    else{
      this.message = "Vous devez fournir une adresse email valide ! ";
      const messageModalBtn = document.getElementById("btnModal");
      messageModalBtn?.click();
      
    }
   
  }

  // goLogin(){
  //   if (this.user.emailu!=""){
  //   window.location.assign("login");}
  // }

}


