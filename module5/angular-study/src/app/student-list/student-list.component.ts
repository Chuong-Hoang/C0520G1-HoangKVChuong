import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  eList=[
    {id:1, name: 'Chuong', address: 'QT'},
    {id:2, name: 'Chuong', address: 'QB'},
    {id:3, name: 'Chuong', address: 'DN'},
    {id:4, name: 'Chuong', address: 'SG'},
    {id:5, name: 'Chuong', address: 'HN'}
  ]

}
