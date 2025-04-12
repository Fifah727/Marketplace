import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';
import { error } from 'console';

@Injectable({
  providedIn: 'root'
})
export class AnnonceService {
  constructor(private http : HttpClient) {}

  getData():Observable<any[]>{
    return this.http.get<any[]>("http://localhost:8080/annonce",{
      headers: new HttpHeaders({'Content-type':'application/json'})
    }).pipe(
      catchError(error =>{return throwError(error);})
    );

  }
  // GET PRODUIT BY ANNONCE NUMA
  getProduit(numa : number):Observable<any>{
    return this.http.get<any>(`http://localhost:8080/annonce/${numa}`,{
      headers: new HttpHeaders({'Content-type':'application/json'})
    }).pipe(
      catchError(error =>{return throwError(error);})
    );

  }
  // AJOUT NOUVELLE ANNONCE
  createAnnonce(annonce: any): Observable<any> {
    return this.http.post("http://localhost:8080/annonce", annonce);
  }

  // AJOUTER LE NOMBRE DE LIKE DE L'ANNONCE
  likeAnnonce(numa:number):Observable <any> {
    return this.http.put(`http://localhost:8080/annonce/like/${numa}`,{
      headers: new HttpHeaders({'Content-type':'application/json'})
    }).pipe(
      catchError(error =>{return throwError(error);})
    );
  }

  dislikeAnnonce(numa:number):Observable <any> {
    return this.http.put(`http://localhost:8080/annonce/dislike/${numa}`,{
      headers: new HttpHeaders({'Content-type':'application/json'})
    }).pipe(
      catchError(error =>{return throwError(error);})
    );
  }

  suppAnnonce(numa:number):Observable <any>{
    return this.http.delete(`http://localhost:8080/annonce/${numa}`);
  }


  // ENREGISTREMENT

  // get All by idu
  getEnreg(idu:number):Observable<any>{
    return this.http.get<any>(`http://localhost:8080/enreg/${idu}`,{
      headers: new HttpHeaders({'Content-type':'application/json'})
    }).pipe(
      catchError(error =>{return throwError(error);})
    );
  }
  // AJOUT NOUVELLE ENREGISTREMENT
  createEnreg(enreg: any): Observable<any> {
    return this.http.post("http://localhost:8080/enreg", enreg);
  }
  // supp by numa et idu
  suppEnreg(numenreg:number):Observable <any>{
    return this.http.delete(`http://localhost:8080/enreg/${numenreg}`);
  }

 // RECHERCHE PAR NOMPRODUIT
 rechercheNomprod(nomprod:string):Observable<any[]>{
  return this.http.get<any[]>(`http://localhost:8080/annonce/recherche/${nomprod}`,{
    headers: new HttpHeaders({'Content-type':'application/json'})
  }).pipe(
    catchError(error =>{return throwError(error);})
  );
  }

   // RECHERCHE PAR NOMPRODUIT
   rechercheCategprod(categprod:string):Observable<any[]>{
  return this.http.get<any[]>(`http://localhost:8080/annonce/rechercheCat/${categprod}`,{
    headers: new HttpHeaders({'Content-type':'application/json'})
  }).pipe(
    catchError(error =>{return throwError(error);})
  );
  }

    // UPDATE ANNONE
  updateAnnonce(numa:number,annonce:any):Observable <any> {
    return this.http.put(`http://localhost:8080/annonce/${numa}`,annonce);
  }


}
