package auth;

import domain.DC;
import domain.DCMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "makePalletServlet")
public class makePalletServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int DCId = Integer.parseInt(request.getParameter("pluspallet"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        System.out.println("CREATE: " + quantity + " new pallets for: " + DCId);

//        TODO when makePallet is called, need to increment pallet ID.
        DC dc = DCMapper.findDC(DCId);
        dc.restockPallets(quantity);

        request.getRequestDispatcher("internaldashboard.jsp").forward(request, response);
    }

}
