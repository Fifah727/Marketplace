import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';
import { error } from 'console';
import { HttpErrorResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {
  constructor(private http : HttpClient) {}

  getData(idu : number):Observable<any>{
     return this.http.get<any>(`http://localhost:8080/user/${idu}`,{
      headers: new HttpHeaders({'Content-type':'application/json'})
    }).pipe(
      catchError(error =>{return throwError(error);})
    );
  }

//   getUserByEmailMdp(emailu:string,mdpu:string):Observable<any>{
//     return this.http.get<any>(`http://localhost:8080/user/${emailu}/${mdpu}`,{
//      headers: new HttpHeaders({'Content-type':'application/json'})
//    }).pipe(
//      catchError(error =>{return throwError(error);})
//    );
//  }

  //LOGIN USER BY EMAIL AND MDP
  login(email: string, password: string): Observable<any> {
    const body = { email, password };
    return this.http.post("http://localhost:8080/user/login", body).pipe(
      catchError(this.handleError)
    );
  }
  // ERREUR
  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'Une erreur inconnue est survenue';
    if (error.status === 404) {
      errorMessage = 'Utilisateur non trouvé';
    } else if (error.status === 401) {
      errorMessage = 'Mot de passe incorrect';
    }
    return throwError(() => errorMessage);
  }

   // ERREUR SIGN IN
   private handleSignInError(error: HttpErrorResponse) {
    let errorMessage = 'Une erreur inconnue est survenue';
    if (error.status === 401) {
      errorMessage = 'Email déjà utilisé';
    }
    return throwError(() => errorMessage);
  }

  // AJOUT NOUVELLE ANNONCE
  createUser(user: any): Observable<any> {
    return this.http.post("http://localhost:8080/user", user).pipe(
      catchError(this.handleSignInError)
    );
  }

  // AJOUT NOUVELLE ANNONCE
  updateUser(user: any,idu:number): Observable<any> {
    return this.http.put(`http://localhost:8080/user/${idu}`, user);
  }

  // S'ABONNER à un USER
  follow(idu:number):Observable <any> {
    return this.http.put(`http://localhost:8080/user/follow/${idu}`,{
      headers: new HttpHeaders({'Content-type':'application/json'})
    }).pipe(
      catchError(error =>{return throwError(error);})
    );
  }
  // DESABONNER à un USER
  nofollow(idu:number):Observable <any> {
    return this.http.put(`http://localhost:8080/user/nofollow/${idu}`,{
      headers: new HttpHeaders({'Content-type':'application/json'})
    }).pipe(
      catchError(error =>{return throwError(error);})
    );
  }

}
