import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContractViewDialogComponent } from './contract-view-dialog.component';

describe('ContractViewDialogComponent', () => {
  let component: ContractViewDialogComponent;
  let fixture: ComponentFixture<ContractViewDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContractViewDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ContractViewDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
