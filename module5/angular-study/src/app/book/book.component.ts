import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  name:string = '';
  constructor() { }

  ngOnInit(): void {
  }
  showEvent(event){
    this.name = event.target.value;
  }

}
