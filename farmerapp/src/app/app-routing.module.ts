import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainpageComponent } from './dashboard/mainpage/mainpage.component';
import { DefaultComponent } from './default/default/default.component';
import { HomeComponent } from './home/home/home.component';
// import { LoginComponent } from './default/login/login.component';



const routes: Routes = [
  {
    path: '',
    component: DefaultComponent,
  // }, {
  //   path: 'login',
  //   component: LoginComponent
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
