package com.mycomp.krishi.web.v1.controller;

import com.mycomp.common.helper.ResponseEntityHelper;
import com.mycomp.common.response.ApiResponse;
import com.mycomp.krishi.service.api.TransactionService;
import com.mycomp.krishi.web.v1.model.TransactionResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("v1/transactions")
public class TransactionController {

	private final TransactionService transactionService;

	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@GetMapping("/seller")
	public ResponseEntity<ApiResponse<List<TransactionResponse>>> getSellerTransactions(@RequestParam("userId") Long userId) {
		List<TransactionResponse> transactions = transactionService.getSellerTransactions(userId);
		return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(true, "Seller transactions fetched", transactions));
	}

	@GetMapping("/buyer")
	public ResponseEntity<ApiResponse<List<TransactionResponse>>> getBuyerTransactions(@RequestParam("userId") Long userId) {
		List<TransactionResponse> transactions = transactionService.getBuyerTransactions(userId);
		return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(true, "Buyer transactions fetched", transactions));
	}

	@GetMapping("/all")
	public ResponseEntity<ApiResponse<List<TransactionResponse>>> getAllTransactions() {
		List<TransactionResponse> transactions = transactionService.getAllTransactions();
		return ResponseEntityHelper.toSuccessResponseEntity(new ApiResponse<>(true, "All transactions fetched", transactions));
	}
}
