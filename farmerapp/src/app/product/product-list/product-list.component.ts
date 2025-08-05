import { Component, OnInit, ViewChild, Input } from '@angular/core';
import {
  MatTableDataSource, MatSort, MatPaginator
} from '@angular/material';
import { DialogService } from '../../services/dialog.service';
import { ProductComponent } from '../product/product.component';
import { ProductApiService } from '../../services/product-api.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {
  listData: MatTableDataSource<any>;
  displayedColumns: string[] = ['productName', 'description', 'actions'];
  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;
  searchKey: string;
  isSold: boolean = false;

  dataSource = [];

  constructor(private dialogService: DialogService,
    private productApiService: ProductApiService
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
    this.productApiService.getProducts()
      .subscribe(
        responseData => {
          this.handleSuccessResponseForGet(responseData);
        },
        error => {
          console.log("Error ocurred while processing.");
        });
  }

  deleteProduct(row) {
    if (confirm("Are you sure you want ot delete  record?")) {
      var productId = row.productId;
      this.productApiService.deleteProduct(productId)
        .subscribe(
          responseData => {
            this.handleSuccessResponseForDelete(responseData);
          },
          error => {
            console.log("Error ocurred while processing.");
          });
    }
  }

  handleSuccessResponseForGet(responseData) {
      // this.dataSource.;
      this.dataSource.splice(0, this.dataSource.length);
      responseData.forEach(element => {
        this.dataSource.push(element);
      });

      this.initializeAllComponents();
  }

  handleSuccessResponseForDelete(responseData) {
      alert("Product deleted successfully.")
      this.getProducts();
  }

  handleFaailedResponse() {
    console.log("Error ocurred while processing.");
  }

  onSearchClear() {
    this.searchKey = "";
    this.applyFilter();
  }

  applyFilter() {
    this.listData.filter = this.searchKey.trim().toLowerCase();
  }

  addProduct() {
    this.dialogService.openDialog(ProductComponent, {}, false);
  }

  editProduct(row) {
    this.dialogService.openDialogAtRight(ProductComponent, row, true);
  }
}
