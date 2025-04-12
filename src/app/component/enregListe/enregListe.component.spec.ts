/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { EnregListeComponent } from './enregListe.component';

describe('EnregListeComponent', () => {
  let component: EnregListeComponent;
  let fixture: ComponentFixture<EnregListeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnregListeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnregListeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
