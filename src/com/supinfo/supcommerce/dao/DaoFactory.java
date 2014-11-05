package com.supinfo.supcommerce.dao;

import com.supinfo.supcommerce.dao.jpa.JpaCategoryDao;
import com.supinfo.supcommerce.dao.jpa.JpaProductDao;
import com.supinfo.supcommerce.util.PersistenceManager;

public class DaoFactory {
	private static JpaCategoryDao categoryService;
	private static JpaProductDao productService;

	public static CategoryDao getCategoryDao() {
		if (categoryService == null) {
			categoryService = new JpaCategoryDao(PersistenceManager.getEntityManagerFactory());
		}
		return categoryService;
	}

	public static ProductDao getProductDao() {
		if (productService == null) {
			productService = new JpaProductDao(PersistenceManager.getEntityManagerFactory());
		}
		return productService;
	}
}
