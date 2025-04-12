import { Component, OnInit } from '@angular/core';
import { UtilisateurService } from '../../service/Utilisateur.service';
import { CommonModule, NgIf } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SessionService } from './../../service/Session.service';
@Component({
  selector: 'app-login',
  imports:[CommonModule,CommonModule,ReactiveFormsModule,FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private apiService: UtilisateurService,private sessionService:SessionService) { }

  ngOnInit() {}

  foundUser :boolean = false;
 
  // getUserByEmailMdp(): void{
  //   this.apiService.getUserByEmailMdp(this.user.emailu,this.user.mdpu).subscribe({
  //     next: (response) =>  {
  //       console.log('User trouvé ? Id => ', response);
  //       this.foundUser = true;
  //     },
  //     error: (error) => console.error('Erreur :', error)
  //   });
  // }

  email = '';
  password = '';
  message = '';


  login(): void {
    this.apiService.login(this.email, this.password).subscribe({
      next: (userId) => {
        this.sessionService.setItem('idu',userId);
        this.sessionService.setItem('voiruser',userId);
        this.message = `Connexion réussie. ID utilisateur : ${userId}`;

        this.sessionService.removeItem('sonId');
        
        window.location.assign("inside/profil");
      },
      error: (err) => {
        this.message = err;
        const messageModalBtn = document.getElementById("btnModal");
        messageModalBtn?.click();
      }
    });
  }

}
