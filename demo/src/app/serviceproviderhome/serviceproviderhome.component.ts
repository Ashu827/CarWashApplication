import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceproviderService } from '../serviceprovider.service';
import {CarDetails } from '../CarDetails'
import { from } from 'rxjs';


@Component({
  selector: 'app-serviceproviderhome',
  templateUrl: './serviceproviderhome.component.html',
  styleUrls: ['./serviceproviderhome.component.css']
})
export class ServiceproviderhomeComponent implements OnInit {

  constructor(private route : Router, private providerService : ServiceproviderService) { }
  detailsList : any;

  carBookingDetails(){
    this.providerService.getcardetails()
    .subscribe(details => {
      console.log(details)
      if(details){
        this.detailsList = details;
        console.log("data from customer " + this.detailsList);
        console.log("data from customer 0 " + this.detailsList[0].name);
      }
      else{
        alert('please Re-login to your account to get all booking detils')
      }
    }
     
      
    )
  }

  ngOnInit(): void {
    this.carBookingDetails();
  }

}
