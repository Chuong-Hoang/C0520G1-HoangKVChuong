import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContractDetailViewDialogComponent } from './contract-detail-view-dialog.component';

describe('ContractDetailViewDialogComponent', () => {
  let component: ContractDetailViewDialogComponent;
  let fixture: ComponentFixture<ContractDetailViewDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContractDetailViewDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ContractDetailViewDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
