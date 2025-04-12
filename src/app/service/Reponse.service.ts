
import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';
import { error } from 'console';

@Injectable({
  providedIn: 'root'
})
export class ReponseService {

  constructor(private http : HttpClient) {}

 // AJOUT NOUVELLE REPONSE
  createRep(reponse: any): Observable<any> {
    return this.http.post("http://localhost:8080/reponse", reponse);
  }

  // AJOUT NOUVELLE AVIS
  createAvis(avis: any): Observable<any> {
    return this.http.post("http://localhost:8080/avis", avis);
  }

  
  // DELETE AVIS et REPONSE
  deleteAvis(numavis:number):Observable <any> {
      return this.http.delete(`http://localhost:8080/avis/${numavis}`).pipe(
        catchError(error =>{return throwError(error);})
      );
    }
  // DELETE REPONSE
  deleteRep(numrep:number):Observable <any> {
    return this.http.delete(`http://localhost:8080/reponse/id/${numrep}`).pipe(
      catchError(error =>{return throwError(error);})
    );
  }

}
