import {Component, OnInit, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {
  @Output() onClick = new EventEmitter();
  constructor() { }
  emitClick(){
    this.onClick.emit(true);
  }
  emitClick2(){
    this.onClick.emit(false);
  }

  ngOnInit(): void {
  }

}
