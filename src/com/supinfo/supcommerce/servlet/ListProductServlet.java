package com.supinfo.supcommerce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.doa.SupProductDao;

/**
 * Servlet implementation class ListProductServlet
 */
@WebServlet("/listProduct")
public class ListProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("products", SupProductDao.getAllProducts());
		RequestDispatcher rd = request.getRequestDispatcher("/listProduct.jsp");
		rd.forward(request, response);
	}

}
