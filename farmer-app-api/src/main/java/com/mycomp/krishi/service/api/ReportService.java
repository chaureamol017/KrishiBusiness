package com.mycomp.krishi.service.api;

import com.mycomp.krishi.web.v1.model.AdminReportResponse;
import com.mycomp.krishi.web.v1.model.BuyerReportResponse;
import com.mycomp.krishi.web.v1.model.SellerReportResponse;

public interface ReportService {
	SellerReportResponse getSellerReport(Long userId);
	BuyerReportResponse getBuyerReport(Long userId);
	AdminReportResponse getAdminReport();
}
