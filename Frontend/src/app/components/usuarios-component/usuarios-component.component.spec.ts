import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsuariosComponentComponent } from './usuarios-component.component';

describe('UsuariosComponentComponent', () => {
  let component: UsuariosComponentComponent;
  let fixture: ComponentFixture<UsuariosComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsuariosComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UsuariosComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
