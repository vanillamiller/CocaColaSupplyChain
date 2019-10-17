package auth;

import domain.SupplierFacade;
import domain.Transactor;
import domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import domain.AppSession;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.dsig.TransformService;
import java.io.IOException;

@WebServlet(name = "loginServlet")
public class loginServlet extends HttpServlet {


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("dsfssgsgfdgsdfgsdfgsdfgsdf");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        UsernamePasswordToken token=new UsernamePasswordToken(username, password);
        token.setRememberMe(false);

        Subject current=SecurityUtils.getSubject();
        String view="/index.jsp";

        try{
            current.login(token);
            System.out.println("successful login");
            view="internaldashboard.jsp";
            Transactor user= Transactor.get(username);
            AppSession.init(user);
            SupplierFacade sf=new SupplierFacade(user.getID());

            if(AppSession.hasRole("cl")){
                view="retailerdashboard.jsp";
                System.out.println("ttttttt0");
            }
            System.out.println("ttttttt1");
            response.sendRedirect(view);
        }catch(UnknownAccountException | IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("failed to login");
            view = "index.jsp";
            request.setAttribute("errorMessage", "Invalid user or password");

            System.out.println("ttttttt2");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
//        }finally{
//            System.out.println("CCCCCCC");
////            ServletContext servletContext=getServletContext();
////            RequestDispatcher requestDispatcher=servletContext.getRequestDispatcher(view);
////            requestDispatcher.forward(request, response);
//
//        }
//        String user, pw = null;
//        user = request.getParameter("user");
//        pw = request.getParameter("password");
//        response.setContentType("text/html");
//        System.out.println("Hello from Post: Your user name is: " + user + ", Your password is: " + pw + ".");
//
//        if(pw.equals("a")){ //TODO - make password in DB i guess?


// get session, then invalidate then create a new one ensures every time someone logs in it's a new session
//            HttpSession session = request.getSession();
//            session.setAttribute("retailerID",user);
//
//            System.out.println("Retail user " + session.getAttribute("retailerID") + " successfully logged in");
//
//            Integer accessCount;
//            synchronized(session) {
//                accessCount = (Integer)session.getAttribute("accessCount");
//                if (accessCount == null) {
//                    accessCount = 1;   // autobox int to Integer
//                } else {
//                    accessCount = new Integer(accessCount + 1);
//                }
//                session.setAttribute("accessCount", accessCount);
//            }
//
//
//            System.out.println("Session ID: " + session.getId() + " Times accessed: " + accessCount);
//            response.sendRedirect("retailerdashboard.jsp");
//        }else{
//            System.out.println("Retail user " + user + " failed to log in");
//            request.setAttribute("errorMessage", "Invalid user or password");
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        }


//            doGet(request, response);
    }
}
