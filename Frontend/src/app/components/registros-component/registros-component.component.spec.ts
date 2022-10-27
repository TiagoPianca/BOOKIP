import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrosComponentComponent } from './registros-component.component';

describe('RegistrosComponentComponent', () => {
  let component: RegistrosComponentComponent;
  let fixture: ComponentFixture<RegistrosComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistrosComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrosComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
