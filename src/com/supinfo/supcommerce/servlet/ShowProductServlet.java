package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;
import com.supinfo.sun.supcommerce.exception.UnknownProductException;

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
			SupProduct product = SupProductDao.findProductById(id);
			out.println("Name : " + product.getName());
			out.println("Content : " + product.getContent());
			out.println("Price : " + product.getPrice());
		} catch(UnknownProductException e) {
			out.println("Product not found");
		} catch(NumberFormatException e) {
			out.println("Incorrect format");
		}
		
		
	}

}
