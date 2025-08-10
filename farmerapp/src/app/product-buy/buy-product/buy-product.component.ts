import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { TopBarButton } from '../../shared/model/top-bar-button';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { UserDetails } from '../../model/user-details';
import { DialogService } from '../../services/dialog.service';
import { AddEditProductBidComponent } from '../add-edit-product-bid/add-edit-product-bid.component';
import { FarmerProductService } from '../../services/farmer-product.service';
import { FarmerProduct } from 'src/app/model/farmer-product';
import { SnackBarService } from 'src/app/services/snack-bar.service';


@Component({
  selector: 'app-buy-product',
  templateUrl: './buy-product.component.html',
  styleUrls: ['./buy-product.component.scss']
})
export class BuyProductComponent implements OnInit {
  buttons: TopBarButton[] = [
    // {title: 'Create', action: 'create', icon: 'add'}
  ];

  listData: MatTableDataSource<FarmerProduct>;
  displayedColumns: string[] = ['name', 'category', 'description', 'additional_description', 'quantity', 'pricePerUnit', 'expectedPrice', 'city', 'addedOn', 'actions'];
  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;
  searchKey: string;

  dataSource: FarmerProduct[] = [];

  constructor(
    private snackBarService: SnackBarService,
    private dialogService: DialogService,
    private farmerProductService: FarmerProductService,
  ) {

  }

  ngOnInit() {
    this.initializeAllComponents();
    this.getProducts();
  }

  initializeAllComponents() {
    this.listData = new MatTableDataSource(this.dataSource);

    this.listData.sort = this.sort;
    this.listData.paginator = this.paginator;
    this.listData.filterPredicate = (data, filter) => {
      return this.displayedColumns.some(ele => {
        return ele != 'actions' && data[ele].toLowerCase().indexOf(filter) != -1;
      });
    };
  }

  getProducts() {
    this.farmerProductService.getProductToBuy()
      .subscribe((response: FarmerProduct[]) => this.handleGetSuccess(response),
        error => this.snackBarService.notify());
  }

  handleGetSuccess(response: FarmerProduct[]) {
    response.forEach(element => {
      this.dataSource.push(element);
    });

    this.initializeAllComponents();
  }

  onSearchClear() {
    this.searchKey = "";
    this.applyFilter();
  }

  applyFilter() {
    this.listData.filter = this.searchKey.trim().toLowerCase();
  }

  handleButtonClick($event) {
    switch ($event) {
      default:
    }
  }

  addEditBidForProduct(selectedData) {
    this.dialogService.openDialog(AddEditProductBidComponent, selectedData);
  }
}
