package com.supinfo.supcommerce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcommerce.dao.DaoFactory;
import com.supinfo.supcommerce.entity.Category;
import com.supinfo.supcommerce.entity.Product;

/**
 * Servlet implementation class InsertSomeProductServlet
 */
@WebServlet("/auth/basicInsert")
public class InsertSomeProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		product.setName("My Product");
		product.setPrice(10.05F);
		product.setContent("My product is amazing !");

		Category category = new Category();
		category.setName("My amazing category");

		product.setCategory(category);

		DaoFactory.getCategoryDao().addCategory(category);
		DaoFactory.getProductDao().addProduct(product);
	}

}
