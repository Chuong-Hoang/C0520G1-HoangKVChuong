import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {EmployeeService} from "../../../services/employee.service";

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {
  id_msg = 'id is required';
  name_msg = 'name is required';
  birthday_msg = 'birthday is required';
  idCard_msg = 'idCard is required';
  phone_msg = 'phone is required';
  email_msg = 'email is required';
  address_msg = 'address is required';
  salary_msg = 'salary is required';
  division_msg = 'division is required';
  education_msg = 'education is required';
  position_msg = 'position is required';

  public formCreate: FormGroup;
  public maxDate = new Date();
  public minDate = new Date(1920, 0,1);
  educationList: any;
  divisionList: any;
  positionList: any;

  constructor(
    private formBuilder: FormBuilder,
    private employeeService: EmployeeService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.formCreate = this.formBuilder.group({
      id: '',
      name: ['', Validators.required],
      birthday: ['', Validators.required],
      idCard: ['', [Validators.required, Validators.pattern('^[0-9]{9}$')]],
      phone: ['', [Validators.required, Validators.pattern('^((090|091|([\(][\+]84[\)])90|([\(][\+]84[\)])91)[0-9]{7})$')]],
      email: ['', [Validators.required, Validators.email]],
      address: ['', Validators.required],
      salary: ['', Validators.required],
      education: ['', Validators.required],
      position: ['', Validators.required],
      division: ['', Validators.required]
    });
    this.employeeService.getDivision().subscribe(data => this.divisionList = data, error => this.divisionList = []);
    this.employeeService.getEducation().subscribe(data => this.educationList = data, error => this.educationList = []);
    this.employeeService.getPosition().subscribe(data => this.positionList = data, error => this.positionList = []);
    console.log(this.positionList);
  }
  onSubmit(){
    console.log(this.formCreate.value);
    this.employeeService.createNew(this.formCreate.value).subscribe(data => {
      console.log(data);
      this.router.navigate(['/employee-list'], {queryParams: {create_msg: 'Create successfully!', si: true}});
      // this.router.navigateByUrl('employee-list');
    })
  }
}
