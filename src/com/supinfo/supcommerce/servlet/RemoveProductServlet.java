package com.supinfo.supcommerce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.doa.SupProductDao;

/**
 * Servlet implementation class RemoveProductServlet
 */
@WebServlet("/auth/removeProduct")
public class RemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SupProductDao.removeProduct(Long.parseLong(request.getParameter("id")));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			response.sendRedirect(request.getContextPath() + "/listProduct.jsp");
		}
	}

}
