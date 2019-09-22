package auth;

import domain.DC;
import domain.Persistance;
import domain.Pallet;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "amakePalletServlet")
public class makePalletServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer newPalletForDC = null;
        newPalletForDC = Integer.parseInt(request.getParameter("pluspallet"));
        System.out.println("who gets a new pallet: " + newPalletForDC);

//        TODO when makePallet is called, need to increment pallet ID.
        Persistance.makePallet(newPalletForDC);

        request.getRequestDispatcher("internaldashboard.jsp").forward(request, response);
    }

}
