import { Injectable } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material';

@Injectable({
  providedIn: 'root'
})
export class DialogService {

  constructor(private dialog: MatDialog) { }

  openDialog(dialogComponent, selectedData, isEdit) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.width = "40%";

    this.open(dialogComponent, dialogConfig, selectedData, isEdit);
  }
  openDialogAtRight(dialogComponent, selectedData, isEdit) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.width = "60%";
    dialogConfig.height = "100%";
    dialogConfig.position = { top: '0', right: '0' };

    this.open(dialogComponent, dialogConfig, selectedData, isEdit);
  }

  private open(dialogComponent, dialogConfig: MatDialogConfig, selectedData, isEdit: boolean) {
    dialogConfig.data = {
      selectedData: selectedData,
      isEdit: isEdit
    }
    this.dialog.open(dialogComponent, dialogConfig);
  }
}
