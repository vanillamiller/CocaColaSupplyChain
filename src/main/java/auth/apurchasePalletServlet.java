package auth;

import domain.Persistance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "apurchasepPalletServlet")
public class apurchasePalletServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        TODO need to make this add a pallet to the DC that buys it.

        request.getRequestDispatcher("aretailerdashboard.jsp").forward(request, response);
    }

}
