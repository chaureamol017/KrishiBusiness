import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TopBarComponent } from './top-bar/top-bar.component';
import { TopDialogContentComponent } from './top-dialog-content/top-dialog-content.component';
import { MaterialModule } from '../material/material.module';
import { FlexLayoutModule } from '@angular/flex-layout';



@NgModule({
  declarations: [
    TopBarComponent,
    TopDialogContentComponent
  ],
  imports: [
    CommonModule,
    FlexLayoutModule,

    MaterialModule,
  ],
  exports: [
    TopBarComponent,
    TopDialogContentComponent,
  ]
})
export class SharedComponentsModule { }
