package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.insertGroupSelection;
import controller.insertMaterialSelection;

/**
 * Servlet implementation class addMaterialSelection
 */
@WebServlet("/addMaterialSelection")
public class addMaterialSelection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addMaterialSelection() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		if (session.isNew()
				|| !session.getId().equals(application.getAttribute("userID"))) {
			session.invalidate();
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert(\" Your session is terminated Please Try again later!!!\");");
			out.print("	window.location='index.jsp';</script>");
		} else {
			String para = request.getParameter("MaterialName");
			if (para != null) {
				if (!para.equalsIgnoreCase("null")) {

					ArrayList<String> ps = (ArrayList<String>) session
							.getAttribute("MaterialSelected");
					// out.print("<br> size" + ps.size());
					System.out.println(para);
					if (!ps.contains(para)) {
						ps.add(para);
						new insertMaterialSelection()
								.insertIntoMaterialSelection(para);
					}

					session.setAttribute("MaterialSelected", ps);
					response.sendRedirect("NewFile.jsp");
					// RequestDispatcher rd;
					// rd = request.getRequestDispatcher("/NewFile.jsp");
					// rd.forward(request, response);
				} else {
					RequestDispatcher rd;
					rd = request.getRequestDispatcher("/NewFile.jsp");
					rd.forward(request, response);
				}
			} else {
				// RequestDispatcher rd;
				// rd = request.getRequestDispatcher("/NewFile.jsp");
				// rd.forward(request, response);
				response.sendRedirect("NewFile.jsp");
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
