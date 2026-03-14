package com.mycomp.krishi.web.v1.controller;

import com.mycomp.common.helper.ResponseEntityHelper;
import com.mycomp.common.response.ApiResponse;
import com.mycomp.krishi.service.api.CategoryAnalyticsService;
import com.mycomp.krishi.service.api.ReportService;
import com.mycomp.krishi.web.v1.model.AdminReportResponse;
import com.mycomp.krishi.web.v1.model.BuyerReportResponse;
import com.mycomp.krishi.web.v1.model.CategoryAnalyticsResponse;
import com.mycomp.krishi.web.v1.model.SellerReportResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("v1/reports")
public class ReportController {

	private final ReportService reportService;
	private final CategoryAnalyticsService categoryAnalyticsService;

	@Autowired
	public ReportController(ReportService reportService, CategoryAnalyticsService categoryAnalyticsService) {
		this.reportService = reportService;
		this.categoryAnalyticsService = categoryAnalyticsService;
	}

	@GetMapping("/seller")
	public ResponseEntity<ApiResponse<SellerReportResponse>> getSellerReport(
			@RequestParam("userId") Long userId,
			@RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
			@RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
		SellerReportResponse report = reportService.getSellerReport(userId, startDate, endDate);
		return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(true, "Seller report generated", report));
	}

	@GetMapping("/buyer")
	public ResponseEntity<ApiResponse<BuyerReportResponse>> getBuyerReport(
			@RequestParam("userId") Long userId,
			@RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
			@RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
		BuyerReportResponse report = reportService.getBuyerReport(userId, startDate, endDate);
		return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(true, "Buyer report generated", report));
	}

	@GetMapping("/admin")
	public ResponseEntity<ApiResponse<AdminReportResponse>> getAdminReport() {
		AdminReportResponse report = reportService.getAdminReport();
		return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(true, "Admin report generated", report));
	}

	@GetMapping("/category-analytics")
	public ResponseEntity<ApiResponse<CategoryAnalyticsResponse>> getCategoryAnalytics() {
		CategoryAnalyticsResponse analytics = categoryAnalyticsService.getCategoryAnalytics();
		return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(true, "Category analytics generated", analytics));
	}
}
