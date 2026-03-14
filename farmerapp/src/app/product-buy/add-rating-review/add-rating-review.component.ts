import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material';
import { RatingReviewRequest, RatingReviewResponse } from '../../model/rating-review.model';
import { FarmerProduct } from '../../model/farmer-product';
import { LocalStorageService } from '../../services/local-storage.service';
import { RatingReviewService } from '../../services/rating-review.service';
import { SnackBarService } from '../../services/snack-bar.service';

@Component({
  selector: 'app-add-rating-review',
  templateUrl: './add-rating-review.component.html',
  styleUrls: ['./add-rating-review.component.scss'],
  host: {
    'class': 'flex-column-stretch-gap',
  }
})
export class AddRatingReviewComponent implements OnInit {
  reviewForm: FormGroup;
  formTitle = 'Rate & Review';
  selectedProduct: FarmerProduct;
  reviews: RatingReviewResponse[] = [];
  averageRating: number = 0;

  constructor(
    private snackBarService: SnackBarService,
    private localStorageService: LocalStorageService,
    private ratingReviewService: RatingReviewService,
    private dialogRef: MatDialogRef<AddRatingReviewComponent>,
  ) {}

  ngOnInit() {
    const refData = this.dialogRef._containerInstance._config.data;
    this.selectedProduct = refData.selectedData;
    this.formTitle = 'Rate & Review - ' + (this.selectedProduct.product ? this.selectedProduct.product.name : '');
    this.reviewForm = new FormGroup({
      rating: new FormControl('', [Validators.required, Validators.min(1), Validators.max(5)]),
      review: new FormControl(''),
    });
    this.loadReviews();
  }

  loadReviews() {
    this.ratingReviewService.getReviewsForProduct(this.selectedProduct.farmerProductId).subscribe(
      response => {
        if (response && response.success) {
          this.reviews = response.data || [];
        }
      }
    );
    this.ratingReviewService.getAverageRating(this.selectedProduct.userId).subscribe(
      response => {
        if (response && response.success) {
          this.averageRating = response.data || 0;
        }
      }
    );
  }

  submitReview() {
    if (this.reviewForm.invalid) return;

    const formValue = this.reviewForm.value;
    const request: RatingReviewRequest = {
      farmerProductId: this.selectedProduct.farmerProductId,
      reviewerUserId: this.localStorageService.getUserId(),
      ratedUserId: this.selectedProduct.userId,
      rating: formValue.rating,
      review: formValue.review || '',
    };

    this.ratingReviewService.addRatingReview(request).subscribe(
      response => {
        if (response && response.success) {
          this.snackBarService.notify('Review submitted successfully');
          this.loadReviews();
          this.reviewForm.reset();
        } else {
          this.snackBarService.notify(response && response.message ? response.message.toString() : 'Failed to submit review');
        }
      },
      error => {
        this.snackBarService.notify('Error submitting review');
      }
    );
  }

  onClose() {
    this.dialogRef.close();
  }
}
