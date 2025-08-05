package com.mycomp.krishi.service.api;

import java.util.List;
import com.mycomp.krishi.service.model.ProductModel;
public interface ProductService {

	ProductModel save(ProductModel model);
	ProductModel update(ProductModel model);
	ProductModel getById(Long id);
	List<ProductModel> getAll();
	Boolean deleteById(Long id);
}

