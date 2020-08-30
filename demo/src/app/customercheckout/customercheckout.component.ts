import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customercheckout',
  templateUrl: './customercheckout.component.html',
  styleUrls: ['./customercheckout.component.css']
})
export class CustomercheckoutComponent implements OnInit {


  constructor() { }

  CheckPutdummy = JSON.parse(localStorage.getItem('BookingCarDetails'))
    

  submit(value){
    console.log(value)
  }
  ngOnInit(): void {
  }

}
