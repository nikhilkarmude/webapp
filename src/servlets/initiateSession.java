package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class initiateSession
 */
@WebServlet(name = "init.do", urlPatterns = { "/init.do" })
public class initiateSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public initiateSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		PrintWriter out = response.getWriter();
		if(application.getAttribute("UserLogined")!=null){			
			 if(Integer.parseInt(""+application.getAttribute("UserLogined"))==1
					 &&!session.getId().equals(application.getAttribute("userID"))){
				 out.print("<script type=\"text/javascript\">"
				 		+ "alert(\"Other User is accessing this page !!!!\");"
				 		+ "window.location='index.jsp'</script>");		
				 System.out.println("We have suser already!!!!");
				
			}else{
				application.setAttribute("UserLogined", 1);
				application.setAttribute("userID", session.getId());
				response.sendRedirect("NewFile.jsp");
			}
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
