import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DefaultComponent } from './default/default.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule, MatDividerModule, MatIconModule, MatToolbarModule, MatSidenavModule } from '@angular/material';
import { DefaultFooterComponent } from './default-footer/default-footer.component';
import { DefaultHeaderComponent } from './default-header/default-header.component';
import { DefaultContainerComponent } from './default-container/default-container.component';



@NgModule({
  declarations: [
    DefaultComponent,
    DefaultFooterComponent,
    DefaultHeaderComponent,
    DefaultContainerComponent,
  ],
  imports: [
    CommonModule,

    FormsModule,
    ReactiveFormsModule,

    MatButtonModule,
    MatDividerModule,
    MatIconModule,
    MatToolbarModule,
    MatSidenavModule,

  ]
})
export class DefaultModule { }
