/* tslint:disable:no-unused-variable */

import { TestBed, inject } from '@angular/core/testing';
import { AnnonceService } from './Annonce.service';

describe('Service: Annonce', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AnnonceService]
    });
  });

  it('should ...', inject([AnnonceService], (service: AnnonceService) => {
    expect(service).toBeTruthy();
  }));
});
