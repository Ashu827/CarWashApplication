import { Component, OnInit } from '@angular/core';
import { CarDetails} from './CarDetails';
import { CustomerService } from '../customer.service';
import { AbstractControl, FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../User';

@Component({
  selector: 'app-carbooking',
  templateUrl: './carbooking.component.html',
  styleUrls: ['./carbooking.component.css']
})
export class CarbookingComponent implements OnInit {
  public dateValue: Date = new Date();
  myStorage = window.localStorage;
  bookingForm: FormGroup;

  options = ["Saloon","Sports", "Sedan", "Hutchback", "SUV"];
  

  constructor( private apiService : CustomerService, private route : Router) { 
    this.bookingForm = new FormGroup({
    emailId: new FormControl(null, [Validators.required,Validators.email]),
    name : new FormControl(null, Validators.required),
    contactNumber: new FormControl(null, [Validators.required]),
    carModel : new FormControl(null, Validators.required),
    carType : new FormControl(null, Validators.required),
    serviceType : new FormControl(null, Validators.required),
    preferredTime : new FormControl(null, Validators.required),
    message : new FormControl(null, Validators.required),
    address : new FormControl(null, Validators.required),
    subscription  :new FormControl(null, Validators.required)
    });
  }


  isFieldValid(field: string) {
    return !this.bookingForm.get(field).valid && this.bookingForm.get(field).touched;
  }

  displayFieldCss(field: string) {
    return {
      'has-error': this.isFieldValid(field),
      'has-feedback': this.isFieldValid(field)
    };
  }

  carBooking(){
    
    if (this.bookingForm.valid) {
      this.apiService.addCarDetails(this.bookingForm.value)
        .subscribe(
          (data) => {
           console.log(data)
           
            if(data){
            console.log("hello", data);
             let CarDetails = JSON.stringify(this.bookingForm.value)
             localStorage.setItem('BookingCarDetails' , CarDetails)
             
            this.route.navigateByUrl('/checkout')
            }
            
            else{
              alert("invalid details")
            }
          },
          error => {
            console.log(error + 'error')
           }
        );
    }
    else {
      this.validateAllFormFields(this.bookingForm);
    }
    
  }

  validateAllFormFields(formGroup: FormGroup) {
    Object.keys(formGroup.controls).forEach(field => {
      console.log(field);
      const control = formGroup.get(field);
      if (control instanceof FormControl) {
        control.markAsTouched({ onlySelf: true });
      } else if (control instanceof FormGroup) {
        this.validateAllFormFields(control);
      }
    });
  }

  ngOnInit(): void {
  }

  

}
