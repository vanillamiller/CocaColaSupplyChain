package auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "internalLoginServlet")

public class internalLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO password login in feature B
        System.out.println("CocaCola HQ Internal successfully logged in");

        HttpSession session = request.getSession();
        session.invalidate();
        session = request.getSession();

        Integer accessCount;
        synchronized(session) {
            accessCount = (Integer)session.getAttribute("accessCount");
            if (accessCount == null) {
                accessCount = 1;   // autobox int to Integer
            } else {
                accessCount = new Integer(accessCount + 1);
            }
            session.setAttribute("accessCount", accessCount);
        }


        System.out.println("Session ID: " + session.getId() + " Times accessed: " + accessCount);
        response.sendRedirect("internaldashboard.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
