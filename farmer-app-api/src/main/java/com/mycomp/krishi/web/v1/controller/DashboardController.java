package com.mycomp.krishi.web.v1.controller;

import com.mycomp.common.helper.ResponseEntityHelper;
import com.mycomp.common.response.ApiResponse;
import com.mycomp.krishi.persistence.entity.FarmerProductBid;
import com.mycomp.krishi.persistence.repository.FarmerProductBidRepository;
import com.mycomp.krishi.persistence.repository.FarmerProductRepository;
import com.mycomp.krishi.persistence.repository.ProductRepository;
import com.mycomp.krishi.persistence.repository.UserRepository;
import com.mycomp.krishi.web.v1.model.DashboardResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("v1/dashboard")
public class DashboardController {

    @Autowired private FarmerProductRepository farmerProductRepository;
    @Autowired private FarmerProductBidRepository farmerProductBidRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<ApiResponse<DashboardResponse>> getDashboard(
            @RequestParam("userId") Long userId,
            @RequestParam("role") String role) {

        DashboardResponse response = new DashboardResponse();
        response.setRole(role);

        String roleUpper = role.toUpperCase();

        if ("SELLER".equals(roleUpper) || "BOTH".equals(roleUpper) || "ADMIN".equals(roleUpper)) {
            long listed = farmerProductRepository.countByUserId(userId);
            long sold = farmerProductRepository.countByUserIdAndSoldIsTrue(userId);
            double revenue = farmerProductRepository.findByUserId(userId).stream()
                    .filter(fp -> Boolean.TRUE.equals(fp.isSold()))
                    .mapToDouble(fp -> fp.getPricePerUnit() * fp.getQuantity())
                    .sum();
            response.setTotalProductsListed(listed);
            response.setTotalProductsSold(sold);
            response.setTotalProductsUnsold(listed - sold);
            response.setTotalRevenue(revenue);
        }

        if ("BUYER".equals(roleUpper) || "BOTH".equals(roleUpper) || "ADMIN".equals(roleUpper)) {
            long placed = farmerProductBidRepository.countByBuyerUserId(userId);
            long accepted = farmerProductBidRepository.countByBuyerUserIdAndAcceptedIsTrue(userId);
            double spent = farmerProductBidRepository.findByBuyerUserIdAndAcceptedIsTrue(userId).stream()
                    .mapToDouble(b -> b.getQuotedPricePerUnit())
                    .sum();
            response.setTotalBidsPlaced(placed);
            response.setTotalBidsAccepted(accepted);
            response.setTotalBidsPending(placed - accepted);
            response.setTotalAmountSpent(spent);
        }

        if ("ADMIN".equals(roleUpper)) {
            response.setTotalUsers(userRepository.count());
            response.setTotalProducts(productRepository.count());
            response.setTotalFarmerProducts(farmerProductRepository.countAllProducts());
            response.setTotalFarmerProductsSold(farmerProductRepository.countAllSoldProducts());
            response.setTotalBids(farmerProductBidRepository.countAllBids());
            response.setTotalAcceptedBids(farmerProductBidRepository.countAllAcceptedBids());
            double platformRevenue = farmerProductRepository.findAll().stream()
                    .filter(fp -> Boolean.TRUE.equals(fp.isSold()))
                    .mapToDouble(fp -> fp.getPricePerUnit() * fp.getQuantity())
                    .sum();
            response.setPlatformTotalRevenue(platformRevenue);
        }

        return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(true, "Dashboard loaded", response));
    }
}
