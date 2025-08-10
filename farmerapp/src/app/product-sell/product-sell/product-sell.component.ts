import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialogRef, MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { TopBarButton } from '../../shared/model/top-bar-button';
import { ProductBidComponent } from '../product-bid/product-bid.component';
import { DialogService } from '../../services/dialog.service';
import { FarmerProductService } from '../../services/farmer-product.service';
import { SnackBarService } from 'src/app/services/snack-bar.service';
import { AddEditFarmerProductComponent } from '../add-edit-farmer-product/add-edit-farmer-product.component';
import { FarmerProduct } from 'src/app/model/farmer-product';
import { DialogData } from 'src/app/model/dialog-data';

@Component({
  selector: 'app-product-sell',
  templateUrl: './product-sell.component.html',
  styleUrls: ['./product-sell.component.scss'],
  host: {
    'class': 'flex-column-stretch-gap',
  }
})
export class ProductSellComponent implements OnInit {
  buttons: TopBarButton[] = [
    { title: 'Add Product', action: 'create', icon: 'add' }
  ];

  listData: MatTableDataSource<FarmerProduct>;
  displayedColumns: string[] = ['name', 'category', 'description', 'additional_description', 'quantity', 'pricePerUnit', 'expectedPrice', 'city', 'addedOn', 'soldOn', 'actions'];
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

  onSearchClear() {
    this.searchKey = "";
    this.applyFilter();
  }

  applyFilter() {
    this.listData.filter = this.searchKey.trim().toLowerCase();
  }

  handleButtonClick($event) {
    switch ($event) {
      case 'create':
        this.addProduct();
        break;
      default:
    }
  }

  getProducts() {
    this.farmerProductService.getProductToSell()
      .subscribe(response => this.handleGetSuccess(response),
        error => this.snackBarService.notify());
  }

  deleteProduct(row: FarmerProduct) {
    if (confirm("Are you sure you want ot delete  record?")) {
      var farmerProductId = row.farmerProductId;
      this.farmerProductService.deleteProduct1(farmerProductId)
        .subscribe(response => this.handleDeleteSuccess(response),
          error => this.snackBarService.notify());
    }
  }

  handleGetSuccess(response: FarmerProduct[]) {
    this.dataSource.splice(0, this.dataSource.length);
    response.forEach(element => {
      this.dataSource.push(element);
    });

    this.initializeAllComponents();
  }

  handleDeleteSuccess(response) {
    if (response.success) {
      this.snackBarService.notify("Product deleted successfully.")

      this.getProducts();
    } else {
      this.snackBarService.notify()
    }
  }

  addProduct() {
    const ref: MatDialogRef<any, DialogData> = this.dialogService.openDialog(AddEditFarmerProductComponent, {}, false);
    ref.afterClosed().subscribe((response: DialogData) => {
      if (response && response.success && response.action == 'SAVE') {
        this.getProducts();
      }
    });
  }

  editProduct(row: FarmerProduct) {
    const ref: MatDialogRef<any, DialogData> = this.dialogService.openDialogAtRight(AddEditFarmerProductComponent, row, true);
    ref.afterClosed().subscribe((response: DialogData) => {
      if (response && response.success && response.action == 'SAVE') {
        this.getProducts();
      }
    });
  }

  viewBidProduct(row: FarmerProduct, isEdit) {
    this.dialogService.openDialogAtRight(ProductBidComponent, row, isEdit);
  }
}
