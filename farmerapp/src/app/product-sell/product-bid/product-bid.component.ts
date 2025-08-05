import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatTableDataSource, MatDialogRef } from '@angular/material';
import { ProductBidService } from '../../services/product-bid.service';

@Component({
  selector: 'app-product-bid',
  templateUrl: './product-bid.component.html',
  styleUrls: ['./product-bid.component.scss']
})
export class ProductBidComponent implements OnInit {
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;

  listData: MatTableDataSource<any>;
  displayedColumns: string[] = ['productName', 'productCategory', 'buyer', 'sellingRate', 'biddingRate', 'actions'];

  searchKey: string;
  selectedData: any;
  selectedProductName: any;
  formTitle: any = "View Bid For";

  dataSource = [];

  constructor(
    private productBidService: ProductBidService,
    private dialogRef: MatDialogRef<ProductBidComponent>
  ) { }

  ngOnInit() {

    this.initializeAllComponents();

    this.getProductBid();
  }
  initializeAllComponents() {
    this.listData = new MatTableDataSource(this.dataSource);
    this.listData.paginator = this.paginator;


    var refData = this.dialogRef._containerInstance._config.data;
    this.selectedData = refData.selectedData;
    this.selectedProductName = this.selectedData.productName;
  }

  getProductBid() {
    if (localStorage.getItem("registrationFor") == "Farmer") {
      this.getProductBidForFarmer();
    } else {
      this.getProductBidForBuyer();
    }
  }
  getProductBidForBuyer() {
    var productId = this.selectedData.productId;
    this.productBidService.getProductBid(productId).subscribe(
      responseData => {
        this.handleSuccessResponseForGet(responseData);
      },
      error => {
        console.log("Error ocurred while processing.");
      }
    );
  }

  getProductBidForFarmer() {
    var productId = this.selectedData.productId;
    this.productBidService.getProductBid(productId).subscribe(
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
  acceptProductBid(row){

  }
  rejectProductBid(row){

  }
  closeDialog() {
    this.dialogRef.close();
  }
}
