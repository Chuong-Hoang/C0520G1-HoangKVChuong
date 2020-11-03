import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContractDetailDeleteDialogComponent } from './contract-detail-delete-dialog.component';

describe('ContractDetailDeleteDialogComponent', () => {
  let component: ContractDetailDeleteDialogComponent;
  let fixture: ComponentFixture<ContractDetailDeleteDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContractDetailDeleteDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ContractDetailDeleteDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
