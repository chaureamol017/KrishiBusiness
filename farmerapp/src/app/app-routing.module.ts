import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainpageComponent } from './dashboard/mainpage/mainpage.component';
import { HomeComponent } from './home/home/home.component';
import { LoginComponent } from './home/login/login.component';



const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  }, {
    path: 'login',
    component: LoginComponent
  }, {
    // path: 'MyHome/:loggedInUserId',
    path: 'MyHome',
    component: MainpageComponent
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
