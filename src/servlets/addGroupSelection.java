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

/**
 * Servlet implementation class addGroupSelection
 */
@WebServlet("/addGroupSelection")
public class addGroupSelection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addGroupSelection() {
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
			System.out.println("Inside!!!!!!!!!");
			session.invalidate();
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert(\" Your session is terminated Please Try again later!!!\");");
			out.print("	window.location='index.jsp';</script>");

		} else {
			String para = request.getParameter("postionCode");
			if (para != null) {
				if (!para.equalsIgnoreCase("null")) {

					ArrayList<String> ps = (ArrayList<String>) session
							.getAttribute("PositionSelected");
					// out.print("<br> size" + ps.size());
					if (!ps.contains(request.getParameter("postionCode"))) {
						ps.add(request.getParameter("postionCode"));
						new insertGroupSelection()
								.insertIntoGroupSelection(para);
					}

					session.setAttribute("PositionSelected", ps);
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
				RequestDispatcher rd;
				rd = request.getRequestDispatcher("/NewFile.jsp");
				rd.forward(request, response);
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
