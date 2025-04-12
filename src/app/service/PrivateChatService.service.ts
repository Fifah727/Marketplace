import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
// import * as Stomp from 'stompjs';
// import * as SockJS from 'sockjs-client';
import { catchError, Observable, Subject, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PrivateChatService {
  constructor(private http : HttpClient) {}
  // private stompClient: Stomp.Client;
  // private messageSubject = new Subject<any>();

  // GET BY IDU
  getMymessage(idu : number,idu1:number):Observable<any>{
    return this.http.get<any>(`http://localhost:8080/message/conversation/${idu}/${idu1}`,{
      headers: new HttpHeaders({'Content-type':'application/json'})
    }).pipe(
      catchError(error =>{return throwError(error);})
    );

  }
  // AJOUT NOUVELLE ANNONCE
  newMesage(message: any): Observable<any> {
    return this.http.post("http://localhost:8080/message/envoyer", message);
  }

  // GET BY IDU avec qui on a parlé
  getUsersByIdu(idu : number):Observable<any>{
    return this.http.get<any>(`http://localhost:8080/message/usersTalk/${idu}`,{
      headers: new HttpHeaders({'Content-type':'application/json'})
    }).pipe(
      catchError(error =>{return throwError(error);})
    );

  }

  
  // DELETE MESSAGE Between two users
  suppMessage(monId:number,sonId:number):Observable <any>{
    return this.http.delete(`http://localhost:8080/message/deleteConv/${monId}/${sonId}`);
  }

  // Lu
  luMessage(idmessage:number):Observable <any> {
    return this.http.put(`http://localhost:8080/message/lu/${idmessage}`,{
      headers: new HttpHeaders({'Content-type':'application/json'})
    }).pipe(
      catchError(error =>{return throwError(error);})
    );
  }
  hasNonLu(idu : number):Observable<any>{
    return this.http.get<any>(`http://localhost:8080/message/hasNonLu/${idu}`,{
      headers: new HttpHeaders({'Content-type':'application/json'})
    }).pipe(
      catchError(error =>{return throwError(error);})
    );

  }

  // connect(userId: number): void {
  //   const socket = new SockJS('http://localhost:8080/ws');
  //   this.stompClient = Stomp.over(socket);

  //   this.stompClient.connect({}, () => {
  //     this.stompClient.subscribe(`/user/${userId}/queue/messages`, (message) => {
  //       if (message.body) {
  //         const parsedMessage = JSON.parse(message.body);
  //         this.messageSubject.next(parsedMessage);
  //       }
  //     });
  //   });
  // }

  // onMessage(): Observable<any> {
  //   return this.messageSubject.asObservable();
  // }
}
