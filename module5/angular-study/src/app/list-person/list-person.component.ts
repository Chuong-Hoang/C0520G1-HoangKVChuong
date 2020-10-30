import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-person',
  templateUrl: './list-person.component.html',
  styleUrls: ['./list-person.component.css']
})
export class ListPersonComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  arrPersons = [
    {id:1, name:'Chuong Hoang', age:32},
    {id:2, name:'Huu Quang', age:34},
    {id:3, name:'Le Nhat', age:31},
    {id:4, name:'Son Tra', age:23},
    {id:5, name:'Duy Nguyen', age:26}
  ]

  removeByName(name:string){
    const index = this.arrPersons.findIndex(el => el.name === name);
    this.arrPersons.splice(index, 1);
  }

}
