import { Component } from '@angular/core';

@Component({
  templateUrl: './chuong.component.html',
  selector: 'app-chuong',
  styleUrls: ['./chuong.component.css']
})

export class ChuongComponent {
  en:string = "hello";
  vn:string = "xin chào";
  imgUrl:string = "https://angular.io/assets/images/logos/angular/shield-large.svg";
  forgot:boolean = false;

  toggleForgot(){
    this.forgot = !this.forgot;
  }
}
