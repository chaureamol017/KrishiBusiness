import { Component, OnInit, ViewChild, Input } from '@angular/core';
import {
  MatTableDataSource, MatSort, MatPaginator,
  MatDialogRef
} from '@angular/material';
import { DialogService } from '../../services/dialog.service';
import { ProductService } from '../../services/product.service';
import { AddEditProductComponent } from '../add-edit-product/add-edit-product.component';
import { Product } from '../../model/product';
import { SnackBarService } from '../../services/snack-bar.service';
import { DialogData } from '../../model/dialog-data';
import { CellActionButton } from '../../shared/model/cell-action-button';
import { TopBarButton } from '../../shared/model/top-bar-button';
import { LocalStorageService } from '../../services/local-storage.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss'],
  host: {
    'class': 'flex-column-stretch-gap',
  }
})
export class ProductListComponent implements OnInit {
  buttons: TopBarButton[] = [];
  actions: CellActionButton[] = [];

  displayedColumns: string[] = ['productName', 'description', 'category', 'actions'];
  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;
  searchKey: string;
  isSold: boolean = false;

  listData: MatTableDataSource<Product>;
  dataArr: Product[] = [];

  constructor(
    private localStorageService: LocalStorageService,
    private snackBarService: SnackBarService,
    private dialogService: DialogService,
    private productService: ProductService
  ) {
    if (this.localStorageService.isAdminUser()){
      this.buttons.push({ title: 'Create', action: 'add', icon: 'add' });

      this.actions.push({ action: 'edit', icon: 'edit' });
      // this.actions.push({ action: 'delete', icon: 'delete' });
    }
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

  onSearchClear() {
    this.searchKey = "";
    this.applyFilter();
  }

  applyFilter() {
    this.listData.filter = this.searchKey.trim().toLowerCase();
  }

  handleError(error: any, message?: string) {
    this.snackBarService.openTopCenter(message)
  }

  getProducts() {
    this.productService.getProducts()
      .subscribe(resp => this.handleGetSuccess(resp),
        error => this.handleError(error, "Error ocurred fetching products."));
  }

  handleGetSuccess(responseData: Product[]) {
    this.dataArr.splice(0, this.dataArr.length);
    responseData.forEach(element => {
      this.dataArr.push(element);
    });

    this.initializeAllComponents();
  }

  handleButtonClick($event: string) {
    switch($event) {
      case 'add':
        this.addEditProduct();
    }
  }

  onActionClick($event: any, row: Product) {
    switch($event) {
      case 'edit':
        this.addEditProduct(row);
        break;
      case 'delete':
        this.deleteProduct(row);
        break;
        default:
    }
  }

  deleteProduct(row) {
    if (confirm("Are you sure you want ot delete  record?")) {
      var productId = row.productId;
      this.productService.deleteProduct(productId)
        .subscribe(resp => this.handleDeleteSuccess(resp),
          error => this.handleError(error, "Error ocurred deleting product."));
    }
  }

  handleDeleteSuccess(response) {
    this.snackBarService.openTopCenter("Product deleted successfully.", 'OK')
    this.getProducts();
  }

  addEditProduct(product?: Product) {
    const data: any = product ? product : {};
    const isEdit: boolean = product ? true : false;
    const ref: MatDialogRef<AddEditProductComponent, DialogData> = this.dialogService.openDialog(AddEditProductComponent, data, isEdit);

    ref.afterClosed().subscribe((resp: DialogData) => {
      if (resp && resp.action == 'SAVE' && resp.success) {
        this.getProducts();
      }
    })
  }
}
