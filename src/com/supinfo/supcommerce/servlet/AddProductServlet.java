package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcommerce.entity.Category;
import com.supinfo.supcommerce.entity.Product;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/auth/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emf;
	@Override
	public void init() throws ServletException {
		emf = Persistence.createEntityManagerFactory("PU");
	}
	@Override
	public void destroy() {
		emf.close();
	}
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
		EntityManager em = emf.createEntityManager();

		Product product = new Product();
		product.setName(name);
		product.setContent(content);
		product.setPrice(price);

		Category category = em.find(Category.class, categoryId);
		product.setCategory(category);

		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		em.close();
		
		response.sendRedirect(request.getContextPath() + "/showProduct.jsp?id=" + product.getId());
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT c FROM Category AS c");
		List<Category> categories = query.getResultList();
		em.close();

		request.setAttribute("categories", categories);
		RequestDispatcher rd = request.getRequestDispatcher("/auth/addProduct.jsp");
		rd.forward(request, response);
	}
}
