import { LikeAnnonceService } from './../../service/LikeAnnonce.service';
import { Component, ElementRef, OnInit, Renderer2 } from '@angular/core';
import { ProduitsService } from '../../service/Produits.service';
import { response } from 'express';
import { error } from 'console';
import { AnnonceService } from '../../service/Annonce.service';
import { CommonModule, NgFor,NgIf } from '@angular/common';
import { SessionService } from './../../service/Session.service';
import { ReponseService } from '../../service/Reponse.service';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

@Component({
  selector: 'app-produit_page',
  imports : [NgFor,NgIf,CommonModule,ReactiveFormsModule,FormsModule],
  templateUrl: './produit_page.component.html',
  styleUrls: ['./produit_page.component.css']
})
export class Produit_pageComponent implements OnInit {

  annonce:any=null;
  
  constructor(private service:AnnonceService,
    public sessionService:SessionService,
    private repService:ReponseService,
    private renderer : Renderer2,
    private el : ElementRef,
    public likeAnnonceService:LikeAnnonceService
  ){}

  ngOnInit(){
    if (this.sessionService.getItem('numa')){
      this.getDataAnnonce();
    }
  //  alert(this.sessionService.getItem('numa'));
    this.loading = true;
  }
  loading : boolean = true;
  getDataAnnonce(){
    this.service.getProduit(this.sessionService.getItem('numa')).subscribe(
      (data) =>{
      this.annonce = data;
      this.loading = false;
    },
    (error) => {
      console.error(error);
      
    }
  );
  }

  voirUser(idu : number){
    this.sessionService.setItem('voiruser',idu);
    //alert(this.sessionService.getItem('voiruser'));
  }

  // AFFICHER LE BOITE DE COMMENTAIRE : reponse


  // ENREGISTRER REPONSE commentaire
  reponse: any = {
    idu : 0,
    numavis : 0,
    date: new Date().toISOString().split('T')[0], // Date du jour
    heure: new Date().toLocaleTimeString('fr-FR', { hour12: false }), // Heure actuelle
    texterep : ""
   
  };

  // ENVOYER REPONSE
  envoyerRep(numavis:number) {
    this.reponse.idu = this.sessionService.getItem('idu');
    this.reponse.numavis = numavis;
    this.repService.createRep(this.reponse).subscribe({
      next: (response) => {this.getDataAnnonce()},
      error: (error) => console.error('Erreur :', error)
    });
  }

  // ENREGISTRER AVIS
  avis: any = {
    idu : 1,
    codeprod : 1,
    dateavis: new Date().toISOString().split('T')[0], // Date du jour
    noteavis: 1,
    commentaire : "",
    nblikeavis : 0
   
  };
  // ENVOYER avis
  envoyerAvis(codeprod:number) {
    
    this.avis.codeprod = codeprod;
    this.avis.idu = this.sessionService.getItem('idu');

    this.repService.createAvis(this.avis).subscribe({
      next: (response) => {
        this.getDataAnnonce();
      //   this.service.getProduit(this.sessionService.getItem('numa')).subscribe(
      //   (data) =>{
      //     this.annonce = data;
      //   },
      //   (error) => {
      //     console.error(error);
      //   })
       },

      error: (error) => console.error('Erreur :', error)
    });
  }

  noteAvis:number = 1;
  plusNoteAvis(event:Event){
    const notedonnee = document.getElementById("noteavis") as HTMLInputElement;
    this.noteAvis =notedonnee.valueAsNumber;
     
  }

  dejaLiker : boolean = false;
  // LIKER UNE ANNONCE
  likeannonce(idu:number,numa : number){
    // Si deja liké , dislike
    if (this.likeAnnonceService.dejaLiker(idu,numa)){
      this.service.dislikeAnnonce(numa).subscribe({
        next: (response) => this.getDataAnnonce(),
        error: (error) => console.error('Erreur :', error)
      });
      this.likeAnnonceService.dislike(idu,numa);
      this.dejaLiker = this.likeAnnonceService.dejaLiker(idu,numa);
      
    }
    else{
      this.service.likeAnnonce(numa).subscribe({
        next: (response) => this.getDataAnnonce(),
        error: (error) => console.error('Erreur :', error)
      });
      this.likeAnnonceService.like(idu,numa);
      this.dejaLiker = this.likeAnnonceService.dejaLiker(idu,numa);
    }
    
  }

  // SUPPRIMER SON PROPRE AVIS
  suppAvis(numavis:number){
    this.repService.deleteAvis(numavis).subscribe({
      next: (response) => this.getDataAnnonce(),
      error: (error) => console.error('Erreur :', error)
    });
  }

  // AFFICHER LE BOX POUR reponse
  showBoxComment(numavis:number){
    const divs = this.el.nativeElement.querySelectorAll('.fff');
    divs.forEach((div:HTMLElement)=>{
      const idValue = div.id;
      const isNumeric =! isNaN(Number(idValue));
      if (isNumeric && Number(idValue)===numavis){
        this.renderer.setStyle(div,'display','block');
      }
      else {
        this.renderer.setStyle(div,'display','none');
      }
    });
  }
  
  deleteRep(numrep:number){
    this.repService.deleteRep(numrep).subscribe({
      next: (response) => this.getDataAnnonce(),
      error: (error) => console.error('Erreur :', error)
    });
  }

// DELETE ANNONCE
suppAnnonce(numa:number){
  this.service.suppAnnonce(numa).subscribe({
    next: (response) => window.location.assign("inside/profil"),
    error: (error) => console.error('Erreur :', error)
  });
}

enreg: any = {
  dateenreg: new Date().toISOString().split('T')[0], // Date du jour
  idu: 0,
  numa: 0
  
};

// ENREGISTRER UNE ANNONCE
dejaEnreg : boolean = false;
enregitrer(numa : number){
  // Si deja enregistré, boutton non cliquable
  if (this.likeAnnonceService.dejaenreg(this.sessionService.getItem('idu'),numa)){
    //this.likeAnnonceService.dislike(this.sessionService.getItem('idu'),numa);
    //this.dejaEnreg = this.likeAnnonceService.dejaLiker(this.sessionService.getItem('idu'),numa);
    this.dejaEnreg = false;
  }
  else{
    this.enreg.numa = numa;
    this.enreg.idu = this.sessionService.getItem('idu');
    this.service.createEnreg(this.enreg).subscribe({
      next: (response) => {
        console.log(response);
      },
      error: (error) => console.error('Erreur :', error)
    });
    this.likeAnnonceService.enreg(this.sessionService.getItem('idu'),numa);
    this.dejaEnreg = true;
  }
  
}

envoyerMessage(sonId:number){
  this.sessionService.setItem('sonId',sonId);
  window.location.assign("inside/message");
  //href="inside/message" 
}

updateAnnonce(numa:number){
  this.sessionService.setItem('numaMaj',numa);
  window.location.assign("inside/formulaire");
}

}
