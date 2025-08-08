import { Injectable } from '@angular/core';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarRef, MatSnackBarVerticalPosition, SimpleSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class SnackBarService {

  constructor(
    private snackBar: MatSnackBar,
  ) {}

  notify(message?: string, action?: string) {
    if (!message) {
      message = 'Error ocurred while processing.';
    }
    this.openTopCenter(message, action);
  }

  openTopCenter(message: string, action?: string): MatSnackBarRef<SimpleSnackBar> {    
    const horizontalPosition: MatSnackBarHorizontalPosition = 'center';
    const verticalPosition: MatSnackBarVerticalPosition = 'top';

    return this.open(message, horizontalPosition, verticalPosition, action);
  }

  open(message: string, horizontalPosition: MatSnackBarHorizontalPosition, verticalPosition: MatSnackBarVerticalPosition,
    action?: string, duration?: number): MatSnackBarRef<SimpleSnackBar> {
    if (!action) {
      action = 'Dismiss';
    }
    if (!duration) {
      duration = 2000;
    }
    return this.snackBar.open(message, action, {
      duration: duration,
      horizontalPosition: horizontalPosition,
      verticalPosition: verticalPosition,
    });
  }
}
