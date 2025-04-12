import { Component, OnInit } from '@angular/core';
import { AnnonceService } from '../../service/Annonce.service';
import { response } from 'express';
import { error } from 'console';
import { SessionService } from '../../service/Session.service';
import { NgIf } from '@angular/common';
@Component({
  selector: 'app-annonceListe',
  imports : [NgIf],
  templateUrl: './annonceListe.component.html',
  styleUrls: ['./annonceListe.component.css']
})
export class AnnonceListeComponent implements OnInit {
      
  annonces:any[]=[];
  photoTitre : String = "";
  constructor(private service:AnnonceService,private sessionService:SessionService){}
    
  ngOnInit(){
    if (this.sessionService.getItem('nomprod')){
      this.rechercheNomprod();
    }
    else if (this.sessionService.getItem('categprod') && this.sessionService.getItem('categprod')!="Toutes"){
      this.rechercheCategprod();
    }

    else{
      this.getAllAnnonce();
    }
  }
  loading : boolean = true;
  getAllAnnonce(){
    this.service.getData().subscribe(
      (data) =>{
      this.annonces = data;
      this.loading = false;
    },
    (error) => {
      console.error(error);
    }
  );
  }

  // RECHERCHE par nomprod
  rechMots : string = "";
  rechercheNomprod(){
      this.rechMots = this.sessionService.getItem('nomprod');
      this.service.rechercheNomprod(this.rechMots).subscribe(
        (data) =>{ this.annonces = data;

           this.loading = false; 
        },
      (error) => {console.error(error);}
      );
      this.sessionService.removeItem('nomprod');
     
  }


  // RECHERCHE par categprodRech
  
  rechercheCategprod(){
      this.rechMots = this.sessionService.getItem('categprod');
      this.service.rechercheCategprod(this.rechMots).subscribe(
        (data) =>{ this.annonces = data; this.loading = false; },
      (error) => {console.error(error);}
      );
      this.sessionService.removeItem('categprod');
  }
  
  voirProduit(numa: number) : void {
    this.sessionService.setItem('numa',numa);
    
    //alert(this.sessionService.getItem('numa'));
  }

}
