import { Component, OnInit, ViewChild, Input } from '@angular/core';
import {
  MatDialog, MatDialogConfig,
  MatTableDataSource, MatSort, MatPaginator
} from '@angular/material';
import { ProductComponent } from '../product/product.component';
import { AddbidComponent } from '../bidproduct/addbid/addbid.component';
import { UserDetails } from 'src/app/classes/user-details';
import { BidlistComponent } from '../bidproduct/bidlist/bidlist.component';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: [
    './product-list.component.scss',
    '../../common/commonStyle.scss'
  ]
})
export class ProductListComponent implements OnInit {
  @Input('loggedInUser') loggedInUser: UserDetails = new UserDetails();
  userRole: any = "Buyer";
  listData: MatTableDataSource<any>;
  displayedColumns: string[] = ['productName', 'productCategory', 'grade', 'description', 'user', 'city', 'dateTobeAvailable', 'sellingRate', 'actions'];
  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;
  searchKey: string;
  isSold: boolean = false;

  dataSource = [];

  constructor(
    private dialog: MatDialog,
    private productService: ProductService
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
    this.productService.getProducts()
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
    this.productService.getAllUnsoldProducts()
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
      this.productService.deleteProduct(productId)
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

  addProduct(selectedData) {
    this.openDialogWithConfig(ProductComponent, {}, false, true);
  }

  editProduct(row) {
    this.openDialogWithConfig(ProductComponent, row, true, true);
  }


  viewBidProduct(selectedData, isEdit) {
    this.openDialogWithConfig(BidlistComponent, selectedData, isEdit, true);
  }

  addBidProduct(selectedData) {
    this.openDialogWithConfig(AddbidComponent, selectedData, false, false);
  }

  editBidProduct(selectedData) {
    this.openDialogWithConfig(AddbidComponent, selectedData, true, false);
  }

  openDialogWithConfig(dialogComponent, selectedData, isEdit, viewAtRight) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    if (viewAtRight) {
      dialogConfig.width = "60%";
      dialogConfig.height = "100%";
      dialogConfig.position = { top: '0', right: '0' };
    } else {
      dialogConfig.width = "40%";
    }
    dialogConfig.data = {
      selectedData: selectedData,
      isEdit: isEdit
    }
    this.dialog.open(dialogComponent, dialogConfig);
  }
}
