package com.supinfo.supcommerce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcommerce.dao.DaoFactory;
import com.supinfo.supcommerce.entity.Category;
import com.supinfo.supcommerce.entity.Product;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/auth/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name").trim();
		String content = request.getParameter("content").trim();
		float price;
		long categoryId;

		try {
			price = Float.parseFloat(request.getParameter("price"));
		} catch (NumberFormatException e) {
			price = 0;
		}
		try {
			categoryId = Long.parseLong(request.getParameter("category"));
		} catch (NumberFormatException e) {
			categoryId = 0;
		}

		Product product = new Product();
		product.setName(name);
		product.setContent(content);
		product.setPrice(price);

		Category category = DaoFactory.getCategoryDao().getCategoryByIdWithProducts(categoryId);
		product.setCategory(category);
		DaoFactory.getProductDao().addProduct(product);
		
		response.sendRedirect(request.getContextPath() + "/showProduct.jsp?id=" + product.getId());
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("categories", DaoFactory.getCategoryDao().getAllCategories());
		RequestDispatcher rd = request.getRequestDispatcher("/auth/addProduct.jsp");
		rd.forward(request, response);
	}
}
