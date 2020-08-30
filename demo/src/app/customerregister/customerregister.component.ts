import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';
import { User } from '../User';
import { AbstractControl, FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-customerregister',
  templateUrl: './customerregister.component.html',
  styleUrls: ['./customerregister.component.css']
})
export class CustomerregisterComponent implements OnInit {

  registerForm: FormGroup;

  myStorage = window.localStorage;
  constructor( private route : Router, private apiService : CustomerService) { 
    this.registerForm = new FormGroup({
      name: new FormControl(null, Validators.required),
      emailId: new FormControl(null, [Validators.required, Validators.email]),
      password: new FormControl(null, Validators.required)
    });  
  }
  
  isValid(controlName) {
    return this.registerForm.get(controlName).invalid && (this.registerForm.get(controlName).touched || this.registerForm.get(controlName).dirty);
  }

  register(){
    if(this.registerForm.valid){
      this.apiService.register(this.registerForm.value).subscribe(
        (data)=>{
          if(data){
            console.log("registration completed")
            localStorage.setItem('userdetails',JSON.stringify(this.registerForm.value) )
            this.route.navigateByUrl('/')
          }
          else{
            alert("User alredy registered")
          }
        },error =>{
          console.log(error +"error")
        }
      )
    }
  //   this.apiService.register(this.userDetails).subscribe(
  //   (data)=>{
  //     if(data){
  //     this.router.navigateByUrl('/header')
  //     console.log("user registered")
  //   }
  //   else{
  //     alert("user alredy exist");
  //   }
  // },
  //   err=>{
  //     console.error(err + 'error')
  //   })
     
 }

  ngOnInit(): void {
  }

}
