package com.supinfo.supcommerce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;

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

		try {
			price = Float.parseFloat(request.getParameter("price"));
		} catch (NumberFormatException e) {
			price = 0;
		}

		SupProduct product = new SupProduct();
		product.setName(name);
		product.setContent(content);
		product.setPrice(price);

		SupProductDao.addProduct(product);

		response.sendRedirect(request.getContextPath() + "/showProduct.jsp?id=" + product.getId());
	}

}
