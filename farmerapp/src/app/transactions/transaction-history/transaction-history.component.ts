import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { Transaction } from '../../model/transaction.model';
import { TransactionService } from '../../services/transaction.service';
import { LocalStorageService } from '../../services/local-storage.service';
import { SnackBarService } from '../../services/snack-bar.service';

@Component({
  selector: 'app-transaction-history',
  templateUrl: './transaction-history.component.html',
  styleUrls: ['./transaction-history.component.scss']
})
export class TransactionHistoryComponent implements OnInit {
  userRole: string;
  activeTab = '';
  isLoading = true;
  errorMessage = '';

  listData: MatTableDataSource<Transaction>;
  displayedColumns: string[] = [];
  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;

  transactions: Transaction[] = [];

  constructor(
    private transactionService: TransactionService,
    private localStorageService: LocalStorageService,
    private snackBarService: SnackBarService,
  ) {}

  ngOnInit() {
    this.userRole = this.localStorageService.getRole();
    const role = this.userRole ? this.userRole.toUpperCase() : '';

    if (role === 'ADMIN') {
      this.activeTab = 'all';
    } else if (role === 'BOTH') {
      this.activeTab = 'seller';
    } else if (role === 'SELLER') {
      this.activeTab = 'seller';
    } else {
      this.activeTab = 'buyer';
    }

    this.loadTransactions();
  }

  setActiveTab(tab: string) {
    this.activeTab = tab;
    this.loadTransactions();
  }

  loadTransactions() {
    this.isLoading = true;
    this.errorMessage = '';

    let observable;
    if (this.activeTab === 'all') {
      this.displayedColumns = ['productName', 'category', 'quantity', 'pricePerUnit', 'totalAmount', 'city', 'sellerName', 'buyerName', 'soldOn'];
      observable = this.transactionService.getAllTransactions();
    } else if (this.activeTab === 'seller') {
      this.displayedColumns = ['productName', 'category', 'quantity', 'pricePerUnit', 'totalAmount', 'city', 'buyerName', 'soldOn'];
      observable = this.transactionService.getSellerTransactions();
    } else {
      this.displayedColumns = ['productName', 'category', 'quantity', 'pricePerUnit', 'totalAmount', 'city', 'sellerName', 'soldOn'];
      observable = this.transactionService.getBuyerTransactions();
    }

    observable.subscribe(
      response => {
        this.isLoading = false;
        if (response && response.success) {
          this.transactions = response.data || [];
          this.listData = new MatTableDataSource(this.transactions);
          this.listData.sort = this.sort;
          this.listData.paginator = this.paginator;
        } else {
          this.errorMessage = (response && response.message) ? response.message.toString() : 'Failed to load transactions.';
        }
      },
      error => {
        this.isLoading = false;
        this.errorMessage = 'Could not connect to server.';
      }
    );
  }

  get showSellerTab(): boolean {
    const role = this.userRole ? this.userRole.toUpperCase() : '';
    return role === 'SELLER' || role === 'BOTH' || role === 'ADMIN';
  }

  get showBuyerTab(): boolean {
    const role = this.userRole ? this.userRole.toUpperCase() : '';
    return role === 'BUYER' || role === 'BOTH' || role === 'ADMIN';
  }

  get showAllTab(): boolean {
    const role = this.userRole ? this.userRole.toUpperCase() : '';
    return role === 'ADMIN';
  }
}
