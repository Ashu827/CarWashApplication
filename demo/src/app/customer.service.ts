import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { User} from './User';
import { first } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  [x: string]: any;

  private  baseUrl = "http://localhost:8080/customer/";

  constructor(private http: HttpClient, private router : Router) { }

  register(user : any): Observable<any> {
    console.log("success service")
    console.log(user);
    let url = this.baseUrl + "registration";
    return this.http.post(url, user);
  }

  login(userLogin : User): Observable<any>{
    let url = this.baseUrl + "login";
    return this.http.post(url, userLogin)
  }

  addCarDetails(car : any) : Observable<any>{
    console.log("car service working")
    let url = this.baseUrl + "booking";
    return this.http.post(url, car);
  }
  logout(){
    
  }

  isLoggedIn() {
    return this.afAuth.authState.pipe(first()).toPromise();
 }

 getCarDetail(details : any){
  let url = this.baseUrl + "getcardetails";
  return this.http.post(url, details);

 }
}
