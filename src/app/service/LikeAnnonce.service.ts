import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LikeAnnonceService {
// private readonly STORAGE_KEY = 'likedAnnonce';
private likedAnnonce = "annonceLiker";

getLikes():Record<number,number[]> {
  const data = localStorage.getItem(this.likedAnnonce);
  return data ? JSON.parse(data) : {};
}

like(idu:number,numa:number):void{
  const likes = this.getLikes();
  //const iduStr = idu.toString();
  if (!likes[idu]){
    likes[idu] = [];
  }
  likes[idu].push(numa);
  localStorage.setItem(this.likedAnnonce,JSON.stringify(likes));
  
}

dislike(idu:number,numa:number):void {
  let likes = this.getLikes();
  if (likes[idu]){
    likes[idu] = likes[idu].filter(n=>n!==numa);
    if (likes[idu].length === 0){
      delete likes[idu];
    }
  }
  localStorage.setItem(this.likedAnnonce,JSON.stringify(likes));
}

dejaLiker(idu:number,numa:number):boolean{
  const likes = this.getLikes();
  return likes[idu]?.includes(numa)??false;
}


constructor() { }

// ENREGISTREMENT
private enregs = "enregsAnnonce";

getEnregs():Record<number,number[]> {
  const data = localStorage.getItem(this.enregs);
  return data ? JSON.parse(data) : {};
}

enreg(idu:number,numa:number):void{
  const enregss = this.getEnregs();
  //const iduStr = idu.toString();
  if (!enregss[idu]){
    enregss[idu] = [];
  }
  enregss[idu].push(numa);
  localStorage.setItem(this.enregs,JSON.stringify(enregss));
  
}

suppenreg(idu:number,numa:number):void {
  let enregss = this.getEnregs();
  if (enregss[idu]){
    enregss[idu] = enregss[idu].filter(n=>n!==numa);
    if (enregss[idu].length === 0){
      delete enregss[idu];
    }
  }
  localStorage.setItem(this.enregs,JSON.stringify(enregss));
}

dejaenreg(idu:number,numa:number):boolean{
  const enregss = this.getEnregs();
  return enregss[idu]?.includes(numa)??false;
}

}
