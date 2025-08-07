import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { TopBarButton } from '../../shared/model/top-bar-button';
import { ProductBidComponent } from '../product-bid/product-bid.component';
import { DialogService } from '../../services/dialog.service';
import { FarmerProductService } from '../../services/farmer-product.service';
import { SnackBarService } from 'src/app/services/snack-bar.service';
import { AddEditFarmerProductComponent } from '../add-edit-farmer-product/add-edit-farmer-product.component';

@Component({
  selector: 'app-product-sell',
  templateUrl: './product-sell.component.html',
  styleUrls: ['./product-sell.component.scss']
})
export class ProductSellComponent implements OnInit {
  buttons: TopBarButton[] = [
    { title: 'Add Product', action: 'create', icon: 'add' }
  ];

  listData: MatTableDataSource<any>;
  displayedColumns: string[] = ['productName', 'productCategory', 'grade', 'description', 'user', 'city', 'dateTobeAvailable', 'sellingRate', 'actions'];
  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;
  searchKey: string;


  dataSource = [];

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
        error => {
          this.snackBarService.openTopCenter("Error ocurred while processing.");
        }
      );
  }

  deleteProduct(row) {
    if (confirm("Are you sure you want ot delete  record?")) {
      var productId = row.productId;
      this.farmerProductService.deleteProduct1(productId)
        .subscribe(response => this.handleDeleteSuccess(response),
          error => {
            this.snackBarService.openTopCenter("Error ocurred while processing.");
          }
        );
    }
  }

  handleGetSuccess(responseData) {
    if (responseData.success) {
      const productDetails = eval("(" + responseData.data + ")");
      productDetails.forEach(element => {
        this.dataSource.push(element);
      });

      this.initializeAllComponents();
    } else {
      this.snackBarService.openTopCenter("Error ocurred while processing.")
    }
  }

  handleDeleteSuccess(responseData) {
    if (responseData.success) {
      this.snackBarService.openTopCenter("Product deleted successfully.")

      this.getProducts();
    } else {
      this.snackBarService.openTopCenter("Error ocurred while processing.")
    }
  }

  addProduct() {
    this.dialogService.openDialog(AddEditFarmerProductComponent, {}, false);
  }

  editProduct(row) {
    this.dialogService.openDialogAtRight(AddEditFarmerProductComponent, row, true);
  }

  viewBidProduct(selectedData, isEdit) {
    this.dialogService.openDialogAtRight(ProductBidComponent, selectedData, isEdit);
  }
}
