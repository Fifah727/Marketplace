/* tslint:disable:no-unused-variable */

import { TestBed,inject } from '@angular/core/testing';
import { UtilisateurService } from './Utilisateur.service';

describe('Service: Utilisateur', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UtilisateurService]
    });
  });

  it('should ...', inject([UtilisateurService], (service: UtilisateurService) => {
    expect(service).toBeTruthy();
  }));
});
