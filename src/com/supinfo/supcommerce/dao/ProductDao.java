package com.supinfo.supcommerce.dao;

import java.util.List;

import com.supinfo.supcommerce.entity.Product;

public interface ProductDao {
	Product addProduct(Product product);
	Product findProductById(Long id);
	List<Product> getAllProducts();
	List<Product> getCheaperProducts();
	void updateProduct(Product product);
	void removeProduct(Product product);
}
