package auth;

import domain.Transactor;
import domain.internal.DC;
import mappers.DCMapper;
import mappers.TransactorMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "makePalletServlet")
public class makePalletServlet extends HttpServlet {
    //DCMapper dcmap=new DCMapper();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int DCID = Integer.parseInt(request.getParameter("pluspallet"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        System.out.println("CREATE: " + quantity + " new pallets for: " + DCID);

//        TODO when makePallet is called, need to increment pallet ID.
        Transactor dc= TransactorMapper.find(DCID);



//        try {
//            //dc.restockPallets(quantity);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        request.getRequestDispatcher("internaldashboard.jsp").forward(request, response);
    }

}
