import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { CustomerComponent } from './customer/customer.component';
import { CustomerhomeComponent } from './customerhome/customerhome.component';
import { CustomerloginComponent } from './Customerlogin/Customerlogin.component';
import { CustomerregisterComponent } from './customerregister/customerregister.component';
import { FormsModule,  ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import {CarouselModule} from 'ngx-bootstrap/carousel';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CarbookingComponent } from './carbooking/carbooking.component';
import { CustomerpaymentComponent } from './customerpayment/customerpayment.component';
import { CustomercheckoutComponent } from './customercheckout/customercheckout.component';
import { LoginComponent } from './login/login.component';
import { AddtocartComponent } from './addtocart/addtocart.component';
import { FieldErrorDisplayComponent } from './field-error-display/field-error-display.component';
import { ReviewComponent } from './review/review.component';
import { ServiceproviderloginComponent } from './serviceproviderlogin/serviceproviderlogin.component';
import { ServiceproviderhomeComponent } from './serviceproviderhome/serviceproviderhome.component';
import { BookinghistoryComponent } from './bookinghistory/bookinghistory.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    CustomerComponent,
    CustomerhomeComponent,
    CustomerloginComponent,
    CustomerregisterComponent,
    CarbookingComponent,
    CustomerpaymentComponent,
    CustomercheckoutComponent,
    LoginComponent,
    AddtocartComponent,
    FieldErrorDisplayComponent,
    ReviewComponent,
    ServiceproviderloginComponent,
    ServiceproviderhomeComponent,
    BookinghistoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    CarouselModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
   

  ],
  providers: [ ],
  bootstrap: [AppComponent]
})
export class AppModule { }
