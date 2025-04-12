/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { LikeAnnonceService } from './LikeAnnonce.service';

describe('Service: LikeAnnonce', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LikeAnnonceService]
    });
  });

  it('should ...', inject([LikeAnnonceService], (service: LikeAnnonceService) => {
    expect(service).toBeTruthy();
  }));
});
