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

import controller.MaxRecord;
import controller.saveEvent;

/**
 * Servlet implementation class SaveFormSelection
 */
@WebServlet("/SaveFormSelection.do")
public class SaveFormSelection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveFormSelection() {
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
			ArrayList<String> ms = (ArrayList<String>) session
					.getAttribute("MaterialSelected");
			ArrayList<String> ps = (ArrayList<String>) session
					.getAttribute("PositionSelected");
			if (!(ps.isEmpty() || ms.isEmpty())) {
				new saveEvent().SaveEventExecuteInsertDate(""
						+ session.getAttribute("Date"));
				new saveEvent().saveMailingHistory();
				new saveEvent().saveMailingHistoryPositionCodes();
				String maxid = "" + session.getAttribute("LastMaxID");
				if (maxid.endsWith(new MaxRecord().getMaxIDRecord())) {
					session.setAttribute("Save", true);
				}
			}
			response.sendRedirect("Refresh.do");
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
