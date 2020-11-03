import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContractDeleteDialogComponent } from './contract-delete-dialog.component';

describe('ContractDeleteDialogComponent', () => {
  let component: ContractDeleteDialogComponent;
  let fixture: ComponentFixture<ContractDeleteDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContractDeleteDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ContractDeleteDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
