import { InsideComponent } from './component/inside/inside.component';
import { Routes } from '@angular/router';
import {Produit_pageComponent} from './component/produit_page/produit_page.component';
import {ProfileVendeurComponent} from './component/profile-vendeur/profile-vendeur.component';
import {AnnonceListeComponent} from './component/annonceListe/annonceListe.component';
import { AccueilComponent } from './component/accueil/accueil.component';
import {PortfolioComponent} from './component/portfolio/portfolio.component';
import {MessageComponent} from './component/message/message.component';
import {FormulaireAnnonceComponent} from './component/formulaireAnnonce/formulaireAnnonce.component';
import {LoginComponent} from './component/login/login.component';
import {SigninComponent} from './component/signin/signin.component';
import { EnregListeComponent } from './component/enregListe/enregListe.component';
import {NotFoundComponent} from './component/notFound/notFound.component';
export const routes: Routes = [
    // {path:'',component:PortfolioComponent},
    {path : 'inside',component:InsideComponent,children:[
        {path:'',component:ProfileVendeurComponent},
        {path:'profil',component:ProfileVendeurComponent},
        {path:'annonce',component:AnnonceListeComponent},
        {path:'message',component:MessageComponent},
        {path:'produitPage',component:Produit_pageComponent},
        {path:'formulaire',component:FormulaireAnnonceComponent},
        {path:'enreg',component:EnregListeComponent},
    ]},

    {path:'',component:LoginComponent},
    {path:'login',component:LoginComponent},
    {path : 'signin',component:SigninComponent},
    {path:'**',component:NotFoundComponent}

];
