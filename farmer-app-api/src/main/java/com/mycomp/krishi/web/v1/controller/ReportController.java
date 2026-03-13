package com.mycomp.krishi.web.v1.controller;

import com.mycomp.common.helper.ResponseEntityHelper;
import com.mycomp.common.response.ApiResponse;
import com.mycomp.krishi.service.api.ReportService;
import com.mycomp.krishi.web.v1.model.AdminReportResponse;
import com.mycomp.krishi.web.v1.model.BuyerReportResponse;
import com.mycomp.krishi.web.v1.model.SellerReportResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("v1/reports")
public class ReportController {

	private final ReportService reportService;

	@Autowired
	public ReportController(ReportService reportService) {
		this.reportService = reportService;
	}

	@GetMapping("/seller")
	public ResponseEntity<ApiResponse<SellerReportResponse>> getSellerReport(@RequestParam("userId") Long userId) {
		SellerReportResponse report = reportService.getSellerReport(userId);
		return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(true, "Seller report generated", report));
	}

	@GetMapping("/buyer")
	public ResponseEntity<ApiResponse<BuyerReportResponse>> getBuyerReport(@RequestParam("userId") Long userId) {
		BuyerReportResponse report = reportService.getBuyerReport(userId);
		return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(true, "Buyer report generated", report));
	}

	@GetMapping("/admin")
	public ResponseEntity<ApiResponse<AdminReportResponse>> getAdminReport() {
		AdminReportResponse report = reportService.getAdminReport();
		return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(true, "Admin report generated", report));
	}
}
