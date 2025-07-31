import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TopBarComponent } from './top-bar/top-bar.component';
import { MatButtonModule, MatIconModule, MatToolbarModule } from '@angular/material';
import { TopDialogContentComponent } from './top-dialog-content/top-dialog-content.component';



@NgModule({
  declarations: [
    TopBarComponent,
    TopDialogContentComponent
  ],
  imports: [
    CommonModule,

    MatButtonModule,
    MatIconModule,
    MatToolbarModule,
  ],
  exports: [
    TopBarComponent,
    TopDialogContentComponent,
  ]
})
export class SharedComponentsModule { }
