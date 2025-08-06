import { Injectable } from '@angular/core';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material';
import { DialogData } from '../model/dialog-data';

@Injectable({
  providedIn: 'root'
})
export class DialogService {

  constructor(private dialog: MatDialog) { }

  openDialog(dialogComponent, selectedData, isEdit: boolean): MatDialogRef<any, DialogData> {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.width = "40%";

    return this.open(dialogComponent, dialogConfig, selectedData, isEdit);
  }

  openDialogAtRight(dialogComponent, selectedData, isEdit: boolean): MatDialogRef<any, DialogData> {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.width = "60%";
    dialogConfig.height = "100%";
    dialogConfig.position = { top: '0', right: '0' };

    return this.open(dialogComponent, dialogConfig, selectedData, isEdit);
  }

  private open(dialogComponent, dialogConfig: MatDialogConfig, selectedData, isEdit: boolean): MatDialogRef<any, DialogData> {
    dialogConfig.data = {
      selectedData: selectedData,
      isEdit: isEdit
    }
    return this.dialog.open(dialogComponent, dialogConfig);
  }
}
