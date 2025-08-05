import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { TopBarButton } from '../../shared-components/model/top-bar-button';
import { UserDetails } from '../../model/user-details';
import { ProductBidComponent } from '../product-bid/product-bid.component';
import { ProductComponent } from '../../entry-components/product/product.component';
import { DialogService } from '../../services/dialog.service';
import { ProductApiService } from '../../services/product-api.service';

@Component({
  selector: 'app-sell-product',
  templateUrl: './sell-product.component.html',
  styleUrls: ['./sell-product.component.scss']
})
export class SellProductComponent implements OnInit {
  buttons: TopBarButton[] = [
    { title: 'Create', action: 'create', icon: 'add' }
  ];

  @Input('loggedInUser') loggedInUser: UserDetails = new UserDetails();
  userRole: any = "Buyer";
  listData: MatTableDataSource<any>;
  displayedColumns: string[] = ['productName', 'productCategory', 'grade', 'description', 'user', 'city', 'dateTobeAvailable', 'sellingRate', 'actions'];
  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;
  searchKey: string;


  dataSource = [];

  constructor(
    private dialogService: DialogService,
    private productApiService: ProductApiService,
  ) {

  }

  ngOnInit() {
    this.userRole = localStorage.getItem("registrationFor");

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

    if (this.userRole == "Farmer") {
      this.getProductsForFarmer();
    } else {
      this.getProductsForBuyer();
    }

  }
  getProductsForFarmer() {
    this.productApiService.getProducts()
      .subscribe(
        responseData => {
          this.handleSuccessResponseForGet(responseData);
        },
        error => {
          console.log("Error ocurred while processing.");
        }
      );
  }
  getProductsForBuyer() {
    this.productApiService.getAllUnsoldProducts()
      .subscribe(
        responseData => {
          this.handleSuccessResponseForGet(responseData);
        },
        error => {
          console.log("Error ocurred while processing.");
        }
      );
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
          }
        );
    }
  }

  handleSuccessResponseForGet(responseData) {
    if (responseData.success) {
      var productDetails = eval("(" + responseData.data + ")");

      // this.dataSource.;
      productDetails.forEach(element => {
        this.dataSource.push(element);
      });

      this.initializeAllComponents();
    } else {
      alert("Error ocurred while processing.")
    }
  }

  handleSuccessResponseForDelete(responseData) {
    if (responseData.success) {
      var productDetails = eval("(" + responseData.data + ")");

      alert("Product deleted successfully.")

      this.getProducts();

    } else {
      alert("Error ocurred while processing.")
    }
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
      case '':
        this.addProduct();
        break;
      default:
    }
  }

  addProduct() {
    this.dialogService.openDialog(ProductComponent, {}, false);
  }

  editProduct(row) {
    this.dialogService.openDialogAtRight(ProductComponent, row, true);
  }

  viewBidProduct(selectedData, isEdit) {
    this.dialogService.openDialogAtRight(ProductBidComponent, selectedData, isEdit);
  }

}
