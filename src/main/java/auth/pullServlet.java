package auth;

import domain.Order;
import domain.Retailer;
import domain.TransactorMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "pullServlet")
public class pullServlet extends HttpServlet {

//    private RetailerMapper rmap=new RetailerMapper();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int DCID = Integer.parseInt(request.getParameter("DCID"));
        int retailerID = Integer.parseInt(request.getParameter("retailerID"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        System.out.println("BUY: Retailer" + retailerID + " buys " + quantity + " new pallets from: " + DCID);

//        TODO when makePallet is called, need to increment pallet ID.
        Retailer retailer = null;
//        try {

            retailer = (Retailer) TransactorMapper.find(retailerID);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        boolean result = false;

        result = retailer.buy(new Order(), DCID);

        if(result==true){
            //           TODO generate transaction!
        }else{
            request.setAttribute("errorMessage", "Not enough pallets available");
        }
        request.getRequestDispatcher("retailerdashboard.jsp").forward(request, response);
    }
}
