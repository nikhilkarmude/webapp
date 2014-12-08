package servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.core.ApplicationContext;

import controller.ClearForm;

/**
 * Servlet implementation class Refresh
 */
@WebServlet("/Refresh.do")
public class Refresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Refresh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean save=false;
		HttpSession session = request.getSession(false);
		if(session.getAttribute("Save")!=null)
		{
			save=(boolean) session.getAttribute("Save");
		}
		if (session != null) {
		    session.invalidate();
		}
		new ClearForm().ClearFormQuery();
		//re.setAttribute("Save", "Success");
		
		 ServletContext sc = getServletContext();
		 sc.setAttribute("UserLogined", 0);
		response.sendRedirect("index.jsp?Save="+save);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
