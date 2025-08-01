import { Component, EventEmitter, inject, Input, OnInit, Output } from '@angular/core';
import { SignUpComponent } from '../../auth/sign-up/sign-up.component';
import { DialogService } from '../../services/dialog.service';
import { LoginComponent } from '../../auth/login/login.component';
import { MatDialog } from '@angular/material/dialog';
import { LocalComponent } from '../../components/local/local.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  readonly dialog = inject(MatDialog);

  appName: string = "Krishi Business";
  isLoggedIn: boolean = false;
  userName: string = "John Doe";
  isSidebarVisible: boolean = false;

  @Output() onToggle: EventEmitter<boolean> = new EventEmitter();

  constructor(
    private router: Router,
    private dialogService: DialogService,
  ) { }

  ngOnInit() {
  }

  login() {
    const dialogRef = this.dialog.open(LocalComponent, {
      position: { top: '100px', left: 'calc(50% - 200px)' },
      width: '400px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
    // this.dialogService.openDialog1(LoginComponent, {}, true);

  }

  signUp() {
    this.router.navigate(['sign-up']);
    // this.dialogService.openDialog(SignUpComponent, {}, false);
  }

  logout() {
    // Add logout logic here
    this.isLoggedIn = false;
  }

  toggleSidebar() {
    this.isSidebarVisible = !this.isSidebarVisible;
    this.onToggle.emit(this.isSidebarVisible);
  }

}
