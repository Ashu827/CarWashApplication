import { Component, OnInit } from '@angular/core';
import { User} from '../User';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
   

  usercredentials = JSON.parse(localStorage.getItem('userdetails'))
  usercardetails = JSON.parse(localStorage.getItem('BookingCarDetails'))
  
  
  constructor( private route  : Router, private apiService : CustomerService) { }
   
  ngOnInit(): void {
    console.log(this.usercardetails + "details")
  }

  logout(){
    window.localStorage.removeItem('userdetails')
    window.localStorage.removeItem('BookingCarDetails')
  }
 
}
