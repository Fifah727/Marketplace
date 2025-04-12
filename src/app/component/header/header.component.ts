import { Component, ElementRef, OnInit, Renderer2 } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AnnonceService } from '../../service/Annonce.service';
import { ReponseService } from '../../service/Reponse.service';
import { SessionService } from '../../service/Session.service';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { PrivateChatService } from '../../service/PrivateChatService.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  imports:[RouterModule,CommonModule,ReactiveFormsModule,FormsModule]
})
export class HeaderComponent implements OnInit {

  constructor(private service:AnnonceService,
    public sessionService:SessionService,
    private repService:ReponseService,
    private renderer : Renderer2,
    private el : ElementRef,
    private privateChatService: PrivateChatService
    
  ){}
  hasNonLuMessage : boolean = false;
  ngOnInit() {
    if (this.sessionService.getItem('idu')){
      this.privateChatService.hasNonLu(this.sessionService.getItem('idu')).subscribe(
        (data) =>{
          this.hasNonLuMessage = data;
        },
        (error) => {

          console.error(error);
        }
      );
    }
  }

  isToggled = false;
  toggle(){
    this.isToggled = !this.isToggled;
  }
  voirUser(){
    this.sessionService.setItem('voiruser',this.sessionService.getItem('idu'));
    //alert(this.sessionService.getItem('voiruser'));
  }
  nomprodRech : string = "";
 // RECHERCHE par nomprod
 rechercheNomprod(){
  //nomprod:string
  this.sessionService.setItem('nomprod',this.nomprodRech);
  window.location.assign("inside/annonce");
 }

 categprodRech : string = "Accessoire";
 // RECHERCHE par nomprod
 rechercheCategprod(){
  //nomprod:string
  this.sessionService.setItem('categprod',this.categprodRech);
  window.location.assign("inside/annonce");
 }

 
}
