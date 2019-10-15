package auth;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import domain.AppSession;
import org.apache.shiro.session.Session;

@WebServlet("/")
public class MainController extends HttpServlet {

    @Override
    public void init(ServletConfig conf) throws ServletException {
        super.init(conf);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String view="/index.jsp";

        ServletContext servCon=getServletContext();

        RequestDispatcher reqDist=servCon.getRequestDispatcher(view);

        reqDist.forward(req, res);

    }

}
