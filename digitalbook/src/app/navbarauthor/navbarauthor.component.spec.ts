import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarauthorComponent } from './navbarauthor.component';

describe('NavbarauthorComponent', () => {
  let component: NavbarauthorComponent;
  let fixture: ComponentFixture<NavbarauthorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavbarauthorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NavbarauthorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
