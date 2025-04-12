import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor() { }
  setItem(key:string,value:any):void{
    sessionStorage.setItem(key,JSON.stringify(value));
  }
  getItem(key:string):any{
    const data = sessionStorage.getItem(key);
    return data ? JSON.parse(data):null;
  }
  removeItem(key:string): void{
    sessionStorage.removeItem(key);
  }
  clearSession(): void {
    sessionStorage.clear();
  }

}
