import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { UserManagementService } from '../../services/user-management.service';
import { SnackBarService } from '../../services/snack-bar.service';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.scss']
})
export class UserManagementComponent implements OnInit {
  isLoading = true;
  errorMessage = '';
  users: any[] = [];
  listData: MatTableDataSource<any>;
  displayedColumns: string[] = ['userId', 'firstName', 'lastName', 'emailId', 'mobile', 'role', 'status', 'actions'];
  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;
  searchKey = '';

  constructor(
    private userManagementService: UserManagementService,
    private snackBarService: SnackBarService,
  ) {}

  ngOnInit() {
    this.loadUsers();
  }

  loadUsers() {
    this.isLoading = true;
    this.errorMessage = '';
    this.userManagementService.getAllUsers().subscribe(
      (response: any[]) => {
        this.isLoading = false;
        this.users = response || [];
        this.listData = new MatTableDataSource(this.users);
        this.listData.sort = this.sort;
        this.listData.paginator = this.paginator;
      },
      error => {
        this.isLoading = false;
        this.errorMessage = 'Could not load users.';
      }
    );
  }

  onSearchClear() {
    this.searchKey = '';
    this.applyFilter();
  }

  applyFilter() {
    this.listData.filter = this.searchKey.trim().toLowerCase();
  }

  toggleActive(user: any) {
    const action = user.active === false ? 'Re-activate' : 'Deactivate';
    if (confirm(`Are you sure you want to ${action} this user?`)) {
      this.userManagementService.toggleActive(user.userId).subscribe(
        (isNowActive: boolean) => {
          user.active = isNowActive;
          this.snackBarService.notify(`User ${isNowActive ? 'activated' : 'deactivated'} successfully`);
        },
        error => {
          this.snackBarService.notify('Failed to update user status');
        }
      );
    }
  }
}
