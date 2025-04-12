import { Component, OnInit } from '@angular/core';
import { PrivateChatService } from './../../service/PrivateChatService.service';
import { CommonModule, NgFor, NgIf } from '@angular/common';
import { SessionService } from '../../service/Session.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
@Component({
  selector: 'app-message',
  imports : [NgFor,NgIf,CommonModule,ReactiveFormsModule,FormsModule],
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {
  constructor(private privateChatService: PrivateChatService,public sessionService:SessionService) {}

  messagesRecus: any[] = [];
  usersWithConv: any[] = [];
  usersFiltre : any[] = [];
  destinataireId: number = 2;
  notification: string = '';
  monId : number = 0;
  sonId : number = 31;
  idMessage : number = 0;

  idMessageALu : number[] = [];

  messageEnvoye: any = {
    iduenvoyeur : this.monId,
    idurecepteur: this.sonId,
    texte:'',
    date:new Date().toISOString().split('T')[0], // Date du jour
    lu:false,
    heure: new Date().toLocaleTimeString('fr-FR', { hour12: false }), // Heure ac
  };

  useRech:string="";
 

  // RECHERche
  rechUsers(){
    if (this.useRech.trim()===""){
      this.usersWithConv = this.usersFiltre;
    }
    else{
      this.usersWithConv = this.usersWithConv.filter(
        item=>item.nomu.toLowerCase().includes(this.useRech.toLowerCase()) ||
        item.prenomu.toLowerCase().includes(this.useRech.toLowerCase())
      );
    }
    
    // if (this.usersWithConv.length==0){
    //   this.usersWithConv = this.usersFiltre;
    // }
  }


  getMymessage(sonId:number){
   //this.sessionService.getItem('idu');
    this.sessionService.setItem('sonId',sonId);
    this.privateChatService.getMymessage(this.sessionService.getItem('idu'),sonId).subscribe(
      (data) =>{
      this.messagesRecus = data;
      //
      this.idMessageALu = this.messagesRecus
      .filter(msg => msg.userenvoyeur.idu !== this.sessionService.getItem('idu'))
      .map(msg => msg.idmessage);

      this.idMessageALu.forEach(id=>{
        this.mettreLu(id);
      });

      this.notif();
    },
    (error) => {
      console.error(error);
    }
    );
    // Mettre lu tous les messages recus 
   
  }

  mettreLu(idmessage:number){
    this.privateChatService.luMessage(idmessage).subscribe({
      next: (response) => this.getMymessage(this.sessionService.getItem('sonId')),
      error: (error) => console.error('Erreur :', error)
    });
  }
  // Avoir la liste des users avec qui on a parlé (une conv existe entre eux)
  getUsersByIdu(){
    this.privateChatService.getUsersByIdu(this.sessionService.getItem('idu')).subscribe(
      (data) =>{
      this.usersWithConv = data;
      this.usersFiltre = data;
      this.notif();
    },
    (error) => {
      console.error(error);
    }
    );
  }


  ngOnInit(): void {
    if(this.sessionService.getItem('sonId')){
      this.getMymessage(this.sessionService.getItem('sonId'));
    }
    //this.getMymessage();
    this.getUsersByIdu();

  }

  // INSERT NEW MESSAGE
  envoyerMessage(){
    
    this.monId = this.sessionService.getItem('idu');
    this.messageEnvoye.iduenvoyeur = this.sessionService.getItem('idu');
    this.messageEnvoye.idurecepteur = this.sessionService.getItem('sonId');
    this.privateChatService.newMesage(this.messageEnvoye).subscribe({
      next: (response) => {
        this.getMymessage(this.sessionService.getItem('sonId'));
        this.getUsersByIdu();
        this.messageEnvoye.texte = "";
      },
      error: (error) => console.error('Erreur :', error)
    });
  }
  notif(): void {
    this.notification = '💬 Nouveau message reçu!';
    //this.playNotificationSound();
  }

  // DELETE MESSAGE BETWEEN MOI ET AUTRE USER
  suppMessage(){
    //this.sonId = 
    this.privateChatService.suppMessage(this.sessionService.getItem('idu'),this.sessionService.getItem('sonId')).subscribe({
      next: (response) => {
        this.getMymessage(this.sonId);
        this.getUsersByIdu();
      },
      error: (error) => console.error('Erreur :', error)
    });
  }

}
