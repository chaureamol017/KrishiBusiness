package com.mycomp.krishi.service.api;

import com.mycomp.krishi.web.v1.model.AdminReportResponse;
import com.mycomp.krishi.web.v1.model.BuyerReportResponse;
import com.mycomp.krishi.web.v1.model.SellerReportResponse;

import java.util.Date;

public interface ReportService {
	SellerReportResponse getSellerReport(Long userId, Date startDate, Date endDate);
	BuyerReportResponse getBuyerReport(Long userId, Date startDate, Date endDate);
	AdminReportResponse getAdminReport();
}
