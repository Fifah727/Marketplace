/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { Produit_pageComponent } from './produit_page.component';

describe('Produit_pageComponent', () => {
  let component: Produit_pageComponent;
  let fixture: ComponentFixture<Produit_pageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Produit_pageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Produit_pageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  
});
