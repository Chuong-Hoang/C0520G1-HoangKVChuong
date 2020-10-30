import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  name:string = "";
  isHighlight:boolean = true;
  evenStyle = {color: 'navy', fontSize: '30px'};
  oddStyle = {color: 'red', fontSize: '15px'};
  currentClass = { circle:this.isHighlight, square:!this.isHighlight };
  constructor() { }

  ngOnInit(): void {
  }
  // showEvent(event){
  //   console.log(event);
  //   this.name = event.target.value;
  // }
}
