package auth;

import domain.Retailer;
import domain.RetailerMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "purchasePalletServlet")
public class purchasePalletServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int DCId = Integer.parseInt(request.getParameter("DCId"));
        int retailerID = Integer.parseInt(request.getParameter("retailerID"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        System.out.println("BUY: Retailer" + retailerID + " buys " + quantity + " new pallets from: " + DCId);

//        TODO when makePallet is called, need to increment pallet ID.
        Retailer retailer = RetailerMapper.findretailer(retailerID);
        if(retailer.buy(quantity, DCId)==false){
            request.setAttribute("errorMessage", "Not enough pallets available");
        }else{
//           TODO generate transaction!
        }
        request.getRequestDispatcher("retailerdashboard.jsp").forward(request, response);
    }
}
