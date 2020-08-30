import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { CustomerhomeComponent } from './customerhome/customerhome.component';
import { CustomerregisterComponent } from './customerregister/customerregister.component';
import { CustomerloginComponent } from './Customerlogin/Customerlogin.component';
import { CarbookingComponent } from './carbooking/carbooking.component';
import { CustomerpaymentComponent } from './customerpayment/customerpayment.component';
import { LoginComponent } from './login/login.component';
import { CustomercheckoutComponent } from './customercheckout/customercheckout.component';
import { CustomerComponent } from './customer/customer.component';
import { AddtocartComponent } from './addtocart/addtocart.component';
import { ServiceproviderloginComponent } from './serviceproviderlogin/serviceproviderlogin.component';
import { ServiceproviderhomeComponent } from './serviceproviderhome/serviceproviderhome.component';
import { BookinghistoryComponent } from './bookinghistory/bookinghistory.component';
import { ReviewComponent } from './review/review.component';

const routes: Routes = [
  { path : '', component : HomeComponent},
  { path : 'header', component : HeaderComponent},
  { path : 'footer', component : FooterComponent},
  { path : "cust-home", component : CustomerhomeComponent},
  { path : 'cust-register', component : CustomerregisterComponent},
  { path : 'cust-login', component : CustomerloginComponent},
  { path : 'car-booking', component : CarbookingComponent},
  { path : 'payment', component: CustomerpaymentComponent},
  { path : 'login', component: LoginComponent},
  { path : 'checkout', component : CustomercheckoutComponent},
  { path : 'customer', component : CustomerComponent},
  { path : 'dummy', component  :AddtocartComponent},
  { path : 'provider-login', component : ServiceproviderloginComponent},
  { path : 'provider-home', component : ServiceproviderhomeComponent},
  { path : 'booking-history', component : BookinghistoryComponent},
  { path : 'review', component : ReviewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
