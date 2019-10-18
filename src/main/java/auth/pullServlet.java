package auth;

import domain.*;

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
        int toID = Integer.parseInt(request.getParameter("toID"));
        int fromID = Integer.parseInt(request.getParameter("fromID"));
        int quantityreg = Integer.parseInt(request.getParameter("quantityreg"));
        int quantityvan = Integer.parseInt(request.getParameter("quantityvan"));
        int quantityzero = Integer.parseInt(request.getParameter("quantityzero"));

        System.out.println("transactor " + toID + " wants quantityreg: " + quantityreg + " quantityvan: " + quantityvan + " quantityzero: " + quantityzero + " from: " + fromID);

        Transactor t = AppSession.getUser();
        System.out.println("this is current stock levels:" + t.getStock());


        if (AppSession.hasRole("bt")){
//            TODO create barrels, change to palletss
            for(int i=0;i<quantityreg;i++){
                System.out.println("ONE NEW BARREL");
                Pallet p = new Pallet(Flavor.REGULAR, AppSession.getUser().getID());
            }
            for(int i=0;i<quantityvan;i++){
                System.out.println("ONE NEW BARREL");
                Pallet p = new Pallet(Flavor.VANILLA, AppSession.getUser().getID());
            }
            for(int i=0;i<quantityzero;i++){
                System.out.println("ONE NEW BARREL");
                Pallet p = new Pallet(Flavor.ZERO, AppSession.getUser().getID());
            }
        }
        else{
            for(int i=0;i<quantityreg;i++){
                System.out.println("MOVE PALLET THROUGH");
            }
            for(int i=0;i<quantityvan;i++){
                System.out.println("MOVE PALLET THROUGH");
            }
            for(int i=0;i<quantityzero;i++){
                System.out.println("MOVE PALLET THROUGH");
            }
        }
//        Retailer retailer = null;
//        try {

//            retailer = (Retailer) TransactorMapper.find(retailerID);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        boolean result = false;

//        result = retailer.buy(new Order(), DCID);

//        if(result==true){
//            //           TODO generate transaction!
//        }else{
//            request.setAttribute("errorMessage", "Not enough pallets available");
//        }
//        request.getRequestDispatcher("retailerdashboard.jsp").forward(request, response);
    }
}
