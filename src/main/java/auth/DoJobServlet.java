package auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletConfig;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */

public class DoJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
//    public void init() throws ServletException {
//        String uni = getServletConfig().getInitParameter("passWordI");
//        String pwi = getServletConfig().getInitParameter("userNameI");
//        System.out.println("init " +uni + pwi);
//      }

    
//    public void service() throws ServletException {
//        String uni = getServletConfig().getInitParameter("passWordI");
//        String pwi = getServletConfig().getInitParameter("userNameI");
//        System.out.println("service " + uni + pwi);
//      }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String un, pw = null;
//		un = request.getParameter("username");
//		pw = request.getParameter("password");
//		response.setContentType("text/html");
//		System.out.println("Hello from GET method");
		PrintWriter writer = response.getWriter();
		writer.println("<h3> Hello in html </h3>");
//		writer.println("<p>Hello from Get username: " + un + " and pword: " + pw + ".</p>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user, pw = null;
		user = request.getParameter("user");
		pw = request.getParameter("password");
		
		
		doGet(request, response);
	}

}
