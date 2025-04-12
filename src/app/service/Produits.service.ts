import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';
import { error } from 'console';

@Injectable({
  providedIn: 'root'
})
export class ProduitsService {

constructor(private http : HttpClient) {}

  getProduits():Observable<any>{
    return this.http.get<any>("http://localhost:8080/produit/1",{
      headers: new HttpHeaders({'Content-type':'application/json'})
    }).pipe(
      catchError(error =>{return throwError(error);})
    );

  }

}
