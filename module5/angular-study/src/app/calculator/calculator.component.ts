import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  firstNum: number;
  secondNum: number;
  result: number;
  operator: string = 'x';

  constructor() {
  }

  ngOnInit(): void {
  }

  getResult(operator: string) {
    switch (operator) {
      case '+':
        this.result = Number(this.firstNum) + Number(this.secondNum);
        break;
      case '-':
        this.result = Number(this.firstNum) - Number(this.secondNum);
        break;
      case 'x':
        this.result = Number(this.firstNum) * Number(this.secondNum);
        break;
      case '/':
        this.result = Number(this.firstNum) / Number(this.secondNum);
        break;
    }
  }
}
