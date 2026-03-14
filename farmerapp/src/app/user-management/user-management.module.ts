import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MaterialModule } from '../material/material.module';
import { SharedModule } from '../shared/shared.module';
import { UserManagementComponent } from './user-management/user-management.component';

@NgModule({
  declarations: [
    UserManagementComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    MaterialModule,
    SharedModule,
  ],
  exports: [
    UserManagementComponent,
  ]
})
export class UserManagementModule { }
