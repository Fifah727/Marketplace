import { Component, OnInit } from '@angular/core';
import { UtilisateurService } from '../../service/Utilisateur.service';
import { AnnonceService } from '../../service/Annonce.service';
import { response } from 'express';
import { error } from 'console';
import { SessionService } from './../../service/Session.service';
import { NgClass } from '@angular/common';
import { NgIf } from '@angular/common';
import { AbonnementService } from '../../service/Abonnement.service';
@Component({
  selector: 'app-profile-vendeur',
  imports:[NgClass,NgIf],
  templateUrl: './profile-vendeur.component.html',
  styleUrls: ['./profile-vendeur.component.css']
})
export class ProfileVendeurComponent implements OnInit {

  user:any=null;
      
  constructor(private service:UtilisateurService,
    public sessionService:SessionService,
    private serviceA:AnnonceService,
    public serviceFollow : AbonnementService
   
  ){}
  
  iduActuel : number = 0;
  ngOnInit(){
    this.profilUser();
  }
  loading : boolean = true;
  profilUser(){
    this.iduActuel =this.sessionService.getItem('idu');
    if (this.sessionService.getItem('voiruser')){
      this.iduActuel = this.sessionService.getItem('voiruser');
    }
    this.service.getData(this.iduActuel).subscribe(
      (data) =>{
        this.user = data;
        this.loading = false;
      },
      (error) => {
        console.error(error);
      }
    );
  }

  voirProduit(numa: number) : void {
    this.sessionService.setItem('numa',numa);
    //alert(this.sessionService.getItem('numa'));
  }

  // S'abonner
  
  followUser(idu:number,followidu : number){
    // Si deja abonné , desabonner
    if (this.serviceFollow.followed(idu,followidu)){
      // SERVICE USER
      this.service.nofollow(followidu).subscribe({
        next: (response) => this.profilUser(),
        error: (error) => console.error('Erreur :', error)
      });
      this.serviceFollow.nofollow(idu,followidu);

    }
    else{
      // SERVICE USER
      this.service.follow(followidu).subscribe({
        next: (response) =>  this.profilUser(),
        error: (error) => console.error('Erreur :', error)
      });
      this.serviceFollow.follow(idu,followidu);
    }
   
  }

// STOCKER DANS UN SESSION IDU A MODIFIER
 maj(idu:number){
  this.sessionService.setItem('iduMaj',idu);
  window.location.assign("signin");
 }

}
