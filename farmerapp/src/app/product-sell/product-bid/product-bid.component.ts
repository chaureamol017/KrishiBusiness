import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatTableDataSource, MatDialogRef } from '@angular/material';
import { ProductBidService } from '../../services/product-bid.service';
import { FarmerProduct } from '../../model/farmer-product';
import { FarmerProductBid, FarmerProductBUyer, ViewFarmerProductBid } from '../../model/farmer-product-bid.model';
import { SnackBarService } from '../../services/snack-bar.service';

@Component({
  selector: 'app-product-bid',
  templateUrl: './product-bid.component.html',
  styleUrls: ['./product-bid.component.scss']
})
export class ProductBidComponent implements OnInit {
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;

  listData: MatTableDataSource<any>;
  displayedColumns: string[] = ['buyer', 'sellingRate', 'biddingRate', 'actions'];

  searchKey: string;
  selectedData: FarmerProduct;
  formTitle: any = 'View Bid For Product';

  dataSource: FarmerProductBid[] = [];
  productBuyers: Map<number, FarmerProductBUyer> = new Map();

  constructor(
    private productBidService: ProductBidService,
    private snackBarService: SnackBarService,
    private dialogRef: MatDialogRef<ProductBidComponent>
  ) { }

  ngOnInit() {
    var refData = this.dialogRef._containerInstance._config.data;
    this.selectedData = refData.selectedData;
    this.formTitle = 'View Bid For ' + this.selectedData.product.name;

    this.initializeAllComponents();
    this.getProductBid();
  }
  initializeAllComponents() {
    this.listData = new MatTableDataSource(this.dataSource);
    this.listData.paginator = this.paginator;

  }

  getProductBid() {
    this.productBidService.getBidForProduct(this.selectedData.farmerProductId).subscribe(
      responseData => this.handleGetSuccess(responseData),
      error => {
        this.snackBarService.notify("Error ocurred while processing.");
      }
    );
  }

  handleGetSuccess(response: ViewFarmerProductBid) {
      response.bids.forEach(element => {
        this.dataSource.push(element);
      });

      response.buyers.forEach(element => {
        this.productBuyers.set(element.userId, element);
      });

      this.initializeAllComponents();
  }

  getBuyerName(buyerUserId: number) {
    const buyer: FarmerProductBUyer = this.productBuyers.get(buyerUserId);
    if (buyer) {
      return buyer.firstName + ' ' + buyer.lastName;
    } else {
      return '';
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
