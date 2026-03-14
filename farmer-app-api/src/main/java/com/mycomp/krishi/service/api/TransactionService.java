package com.mycomp.krishi.service.api;

import com.mycomp.krishi.web.v1.model.TransactionResponse;

import java.util.List;

public interface TransactionService {
	List<TransactionResponse> getSellerTransactions(Long userId);
	List<TransactionResponse> getBuyerTransactions(Long userId);
	List<TransactionResponse> getAllTransactions();
}
