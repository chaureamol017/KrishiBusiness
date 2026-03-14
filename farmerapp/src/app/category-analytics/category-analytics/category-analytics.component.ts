import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { CategoryAnalytics, CategoryDetail } from '../../model/category-analytics.model';
import { CategoryAnalyticsService } from '../../services/category-analytics.service';

@Component({
  selector: 'app-category-analytics',
  templateUrl: './category-analytics.component.html',
  styleUrls: ['./category-analytics.component.scss']
})
export class CategoryAnalyticsComponent implements OnInit {
  analytics: CategoryAnalytics;
  isLoading = true;
  errorMessage = '';
  listData: MatTableDataSource<CategoryDetail>;
  displayedColumns: string[] = ['category', 'totalProducts', 'totalSold', 'totalUnsold', 'totalRevenue', 'totalBids'];
  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;

  // Bar chart: Products by category
  barLabels: string[] = [];
  barData: Array<any> = [
    { data: [], label: 'Total Products' },
    { data: [], label: 'Sold' }
  ];
  barColors = [
    { backgroundColor: '#1976d2' },
    { backgroundColor: '#4caf50' }
  ];
  barOptions = { responsive: true, maintainAspectRatio: false, scales: { yAxes: [{ ticks: { beginAtZero: true } }] } };

  // Doughnut: Revenue by category
  doughnutLabels: string[] = [];
  doughnutData: number[] = [];
  doughnutColors = [{ backgroundColor: ['#1976d2', '#4caf50', '#ff9800', '#f44336', '#9c27b0', '#00bcd4', '#795548'] }];
  doughnutOptions = { responsive: true, maintainAspectRatio: false };

  constructor(private categoryAnalyticsService: CategoryAnalyticsService) {}

  ngOnInit() {
    this.loadAnalytics();
  }

  loadAnalytics() {
    this.isLoading = true;
    this.errorMessage = '';
    this.categoryAnalyticsService.getCategoryAnalytics().subscribe(
      response => {
        this.isLoading = false;
        if (response && response.success) {
          this.analytics = response.data;
          const details = this.analytics.categoryDetails || [];
          this.listData = new MatTableDataSource(details);
          this.listData.sort = this.sort;
          this.listData.paginator = this.paginator;
          this.buildCharts();
        } else {
          this.errorMessage = (response && response.message) ? response.message.toString() : 'Failed to load analytics.';
        }
      },
      error => {
        this.isLoading = false;
        this.errorMessage = 'Could not connect to server.';
      }
    );
  }

  private buildCharts() {
    try {
      const details = this.analytics.categoryDetails || [];
      this.barLabels = details.map(d => d.category);
      this.barData = [
        { data: details.map(d => d.totalProducts), label: 'Total Products' },
        { data: details.map(d => d.totalSold), label: 'Sold' }
      ];

      this.doughnutLabels = details.map(d => d.category);
      this.doughnutData = details.map(d => d.totalRevenue);
    } catch (e) {
      console.error('Chart build error:', e);
    }
  }
}
