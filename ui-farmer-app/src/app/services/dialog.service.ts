import { ComponentType } from '@angular/cdk/portal';
import { Injectable } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';

@Injectable({
  providedIn: 'root'
})
export class DialogService {

  constructor(private dialog: MatDialog) { }


  openDialog1(component: any, data: any, disableClose: boolean = false) {
    this.dialog.open(component, {
      data,
      disableClose,
      width: '400px',
      panelClass: 'custom-dialog',
    });
  }

  openDialog<T>(dialogComponent: ComponentType<T>, selectedData: any, isEdit: boolean) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.width = "40%";

    this.open(dialogComponent, dialogConfig, selectedData, isEdit);
  }
  openDialogAtRight<T>(dialogComponent: ComponentType<T>, selectedData: any, isEdit: boolean) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.width = "60%";
    dialogConfig.height = "100%";
    dialogConfig.position = { top: '0', right: '0' };

    this.open(dialogComponent, dialogConfig, selectedData, isEdit);
  }

  private open<T>(dialogComponent: ComponentType<T>, dialogConfig: MatDialogConfig, selectedData: any, isEdit: boolean) {
    dialogConfig.data = {
      selectedData: selectedData,
      isEdit: isEdit
    }
    this.dialog.open(dialogComponent, dialogConfig);
  }
}
