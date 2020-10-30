import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})
export class PetComponent implements OnInit {
  petName:string = 'puppie';
  petImage:string = 'http://yourdost-blog-images.s3-ap-southeast-1.amazonaws.com/wp-content/uploads/2016/01/03165939/Dogs.jpg';
  constructor() { }

  ngOnInit(): void {
  }
  updateName(name:string){
    this.petName = name;
  }

  updateImage(image:string){
    this.petImage = image;
  }

}
