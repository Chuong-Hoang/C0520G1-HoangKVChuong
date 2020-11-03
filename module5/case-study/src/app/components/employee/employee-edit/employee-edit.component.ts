import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {EmployeeService} from "../../../services/employee.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {
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

  public formEdit: FormGroup;
  public maxDate = new Date();
  public minDate = new Date(1920, 0,1);
  educationList: any;
  divisionList: any;
  positionList: any;
  eleId: any;

  constructor(
    private formBuilder: FormBuilder,
    private employeeService: EmployeeService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.formEdit = this.formBuilder.group({
      id: '',
      name: ['', Validators.required],
      birthday: ['', Validators.required],
      idCard: ['', [Validators.required, Validators.pattern('^[0-9]{9}$')]],
      phone: ['', [Validators.required, Validators.pattern('^((090|091|([\(][\+]84[\)])90|([\(][\+]84[\)])91)[0-9]{7})$')]],
      email: ['', [Validators.required, Validators.email]],
      address: ['', Validators.required],
      salary: ['', Validators.required],
      education: '',
      position: '',
      division: ''
    });

    // only for Edit
    this.route.params.subscribe(data =>{
      this.eleId = data.id;
      this.employeeService.getById(this.eleId).subscribe(dataFromServer =>{
        this.formEdit.patchValue(dataFromServer);
      })
    });

    this.employeeService.getDivision().subscribe(data => this.divisionList = data, error => this.divisionList = []);
    this.employeeService.getEducation().subscribe(data => this.educationList = data, error => this.educationList = []);
    this.employeeService.getPosition().subscribe(data => this.positionList = data, error => this.positionList = []);
    console.log(this.positionList);
  }

 clickToEdit() {
   console.log(this.formEdit.value);
   this.employeeService.editElement(this.eleId, this.formEdit.value).subscribe(data => {
     console.log(data);
     this.router.navigate(['/employee-list'], {queryParams: {edit_msg: 'Update successfully!', si: true}});
     // this.router.navigateByUrl('customer-list');
   })
  }
}
