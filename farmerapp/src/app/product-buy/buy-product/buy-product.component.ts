import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { TopBarButton } from '../../shared-components/model/top-bar-button';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { UserDetails } from 'src/app/model/user-details';
import { DialogService } from 'src/app/services/dialog.service';
import { ProductApiService } from 'src/app/services/product-api.service';
import { AddEditProductBidComponent } from '../add-edit-product-bid/add-edit-product-bid.component';


@Component({
  selector: 'app-buy-product',
  templateUrl: './buy-product.component.html',
  styleUrls: ['./buy-product.component.scss']
})
export class BuyProductComponent implements OnInit {
  buttons: TopBarButton[] = [
    {title: 'Create', action: 'create', icon: 'add'}
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

  addBidProduct(selectedData) {
    this.dialogService.openDialog(AddEditProductBidComponent, selectedData, false);
  }

  editBidProduct(selectedData) {
    this.dialogService.openDialog(AddEditProductBidComponent, selectedData, true);
  }

}
