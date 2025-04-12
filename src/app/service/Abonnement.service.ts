import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AbonnementService {

constructor() { }

private compteAbonnes = "abonnement";

getFollower():Record<number,number[]> {
  const data = localStorage.getItem(this.compteAbonnes);
  return data ? JSON.parse(data) : {};
}

follow(idu:number,followidu:number):void{
  const followers = this.getFollower();
  //const iduStr = idu.toString();
  if (!followers[idu]){
    followers[idu] = [];
  }
  followers[idu].push(followidu);
  localStorage.setItem(this.compteAbonnes,JSON.stringify(followers));
  
}

nofollow(idu:number,followidu:number):void {
  let followers = this.getFollower();
  if (followers[idu]){
    followers[idu] = followers[idu].filter(n=>n!==followidu);
    if (followers[idu].length === 0){
      delete followers[idu];
    }
  }
  localStorage.setItem(this.compteAbonnes,JSON.stringify(followers));
}

followed(idu:number,followidu:number):boolean{
  const followers = this.getFollower();
  return followers[idu]?.includes(followidu)??false;
}


}
