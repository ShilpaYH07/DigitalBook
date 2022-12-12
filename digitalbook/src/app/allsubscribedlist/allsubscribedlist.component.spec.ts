import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllsubscribedlistComponent } from './allsubscribedlist.component';

describe('AllsubscribedlistComponent', () => {
  let component: AllsubscribedlistComponent;
  let fixture: ComponentFixture<AllsubscribedlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllsubscribedlistComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllsubscribedlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
