package auth;

import domain.DC;
import domain.DBDCMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "makePalletServlet")
public class makePalletServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int DCID = Integer.parseInt(request.getParameter("pluspallet"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        System.out.println("CREATE: " + quantity + " new pallets for: " + DCID);

//        TODO when makePallet is called, need to increment pallet ID.
        DC dc = null;
        try {
            dc = DBDCMapper.findDC(DCID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            dc.restockPallets(quantity);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("internaldashboard.jsp").forward(request, response);
    }

}
