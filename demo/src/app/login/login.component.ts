import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';
import { User } from '../User';
import { AbstractControl, FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  constructor( private route : Router, private apiService : CustomerService) { 
    this.loginForm = new FormGroup({
      emailId: new FormControl(null, Validators.required),
      password: new FormControl(null, Validators.required)
    }); 
  }

  isValid(controlName) {
    return this.loginForm.get(controlName).invalid && this.loginForm.get(controlName).touched;
  }

  login() {
    console.log(this.loginForm.value);

    if (this.loginForm.valid) {
      this.apiService.login(this.loginForm.value)
        .subscribe(
          (data) => {
           console.log(data)
           
            if(data){
            console.log("hello", data);
            }
            
            else{
              alert("invalid user")
            }
          },
          error => { }
        );
    }
    
    
  }
  ngOnInit(): void {
  }

}
