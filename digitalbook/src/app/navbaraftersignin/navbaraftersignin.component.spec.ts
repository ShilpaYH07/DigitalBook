import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbaraftersigninComponent } from './navbaraftersignin.component';

describe('NavbaraftersigninComponent', () => {
  let component: NavbaraftersigninComponent;
  let fixture: ComponentFixture<NavbaraftersigninComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavbaraftersigninComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NavbaraftersigninComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
