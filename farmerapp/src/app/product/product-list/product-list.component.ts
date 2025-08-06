import { Component, OnInit, ViewChild, Input } from '@angular/core';
import {
  MatTableDataSource, MatSort, MatPaginator
} from '@angular/material';
import { DialogService } from '../../services/dialog.service';
import { ProductService } from '../../services/product.service';
import { AddEditProductComponent } from '../add-edit-product/add-edit-product.component';
import { Product } from 'src/app/model/product';
import { SnackBarService } from 'src/app/services/snack-bar.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {
  displayedColumns: string[] = ['productName', 'description', 'actions'];
  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;
  searchKey: string;
  isSold: boolean = false;

  listData: MatTableDataSource<Product>;
  dataArr: Product[] = [];

  constructor(
    private snackBarService: SnackBarService,
    private dialogService: DialogService,
    private productService: ProductService
  ) {

  }

  ngOnInit() {
    this.initializeAllComponents();
    this.getProducts();
  }

  initializeAllComponents() {
    this.listData = new MatTableDataSource(this.dataArr);

    this.listData.sort = this.sort;
    this.listData.paginator = this.paginator;
    this.listData.filterPredicate = (data, filter) => {
      return this.displayedColumns.some(ele => {
        return ele != 'actions' && data[ele].toLowerCase().indexOf(filter) != -1;
      });
    };
  }

  getProducts() {
    this.productService.getProducts()
      .subscribe(resp => this.handleGetSuccess(resp),
        error => this.handleError(error, "Error ocurred fetching products."));
  }

  deleteProduct(row) {
    if (confirm("Are you sure you want ot delete  record?")) {
      var productId = row.productId;
      this.productService.deleteProduct(productId)
        .subscribe(resp => this.handleDeleteSuccess(resp),
          error => this.handleError(error, "Error ocurred deleting product."));
    }
  }

  handleGetSuccess(responseData: Product[]) {
      this.dataArr.splice(0, this.dataArr.length);
      responseData.forEach(element => {
        this.dataArr.push(element);
      });

      this.initializeAllComponents();
  }

  handleDeleteSuccess(response) {
      this.snackBarService.openTopCenter("Product deleted successfully.", 'OK')
      this.getProducts();
  }

  handleError(error: any, message?: string) {
      this.snackBarService.openTopCenter(message)
  }

  onSearchClear() {
    this.searchKey = "";
    this.applyFilter();
  }

  applyFilter() {
    this.listData.filter = this.searchKey.trim().toLowerCase();
  }

  addProduct() {
    this.dialogService.openDialog(AddEditProductComponent, {}, false);
  }

  editProduct(row: Product) {
    this.dialogService.openDialogAtRight(AddEditProductComponent, row, true);
  }
}
