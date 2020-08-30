import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from "rxjs/operators";


@Injectable({
  providedIn: 'root'
})
export class ServiceproviderService {

  private  baseUrl = "http://localhost:8082/serviceprovider/";
  constructor(private http: HttpClient, private router : Router) { }

  register(user : any): Observable<any> {
    console.log("success service")
    console.log(user);
    let url = this.baseUrl + "registration";
    return this.http.post(url, user);
  }

  login(userLogin : any): Observable<any>{
    let url = this.baseUrl + "login";
    return this.http.post(url, userLogin)
  }

  getcardetails(){
    let url = this.baseUrl + "getbookingdetails";
    return this.http.get(url);
  }

}
