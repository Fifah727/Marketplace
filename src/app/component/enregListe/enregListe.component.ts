import { Component, OnInit } from '@angular/core';
import { AnnonceService } from '../../service/Annonce.service';
import { response } from 'express';
import { error } from 'console';
import { SessionService } from '../../service/Session.service';
import { NgIf } from '@angular/common';
import { LikeAnnonceService } from '../../service/LikeAnnonce.service';
@Component({
  selector: 'app-enregListe',
  templateUrl: './enregListe.component.html',
  styleUrls: ['./enregListe.component.css']
})
export class EnregListeComponent implements OnInit {

    enregs:any[]=[];
    photoTitre : String = "";
    constructor(private service:AnnonceService,private sessionService:SessionService, public likeAnnonceService:LikeAnnonceService){}
      
    ngOnInit(){
        this.listeEnreg();
    }
    listeEnreg(){
      this.service.getEnreg(this.sessionService.getItem('idu')).subscribe(
        (data) =>{
        this.enregs = data;
        
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

    suppEnreg(numenreg:number,numa:number){
      this.service.suppEnreg(numenreg).subscribe({
        next: (response) => {
          this.listeEnreg();
          this.likeAnnonceService.suppenreg(this.sessionService.getItem('idu'),numa);
        },
        error: (error) => console.error('Erreur :', error)
      });
    }

}
