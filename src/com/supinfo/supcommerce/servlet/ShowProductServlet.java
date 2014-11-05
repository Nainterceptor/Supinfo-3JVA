package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.exception.UnknownProductException;
import com.supinfo.supcommerce.dao.DaoFactory;
import com.supinfo.supcommerce.entity.Product;

/**
 * Servlet implementation class ShowProductServlet
 */
@WebServlet("/showProduct")
public class ShowProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			long id = Long.parseLong(request.getParameter("id"));
			Product product = DaoFactory.getProductDao().findProductById(id);
			if (null == product) {
				response.sendRedirect(request.getContextPath() + "/listProduct");
				return;
			}
			request.setAttribute("product", product);
			request.getRequestDispatcher("/showProduct.jsp").forward(request, response);
		} catch(UnknownProductException e) {
			out.println("Product not found");
		} catch(NumberFormatException e) {
			out.println("Incorrect format");
		}
	}

}
