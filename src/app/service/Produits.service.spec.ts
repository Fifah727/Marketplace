/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ProduitsService } from './Produits.service';

describe('Service: Produits', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProduitsService]
    });
  });

  it('should ...', inject([ProduitsService], (service: ProduitsService) => {
    expect(service).toBeTruthy();
  }));
});
