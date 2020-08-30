import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';
import { CarDetails } from '../carbooking/CarDetails';

@Component({
  selector: 'app-bookinghistory',
  templateUrl: './bookinghistory.component.html',
  styleUrls: ['./bookinghistory.component.css']
})
export class BookinghistoryComponent implements OnInit {

  constructor( private apiService : CustomerService, private route : Router) { }

  datalist : any

  credentials = JSON.parse(localStorage.getItem('userdetails'))
  
  onclick(){
    this.apiService.getCarDetail(this.credentials).subscribe(
      (data)=>{
        if(data){
          console.log("data "+ JSON.stringify(data));
          this.datalist = (data);
         console.log("name " + this.datalist.name)
        }
        else{
          console.log("error")
        }
      }
    )
  }
  ngOnInit(): void {
     this.onclick();
     console.log(this.credentials)
    
  }

  


  getCarDetails(){
    
  }
}
