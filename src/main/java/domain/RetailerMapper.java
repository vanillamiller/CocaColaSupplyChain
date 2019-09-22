package domain;

import java.util.LinkedList;
import java.util.List;

public class RetailerMapper {
    public static List<Retailer> retailers;

    public static List<Retailer> getAllretailers(){
        if (retailers == null) {
            retailers = new LinkedList<Retailer>();
            retailers.add(new Retailer(0,"ColesMelbourne",0));
            retailers.add(new Retailer(1,"ColesSydney",1));
            retailers.add(new Retailer(2,"ColesBrisbane",2));
            retailers.add(new Retailer(3,"ColesMelbourne2",3));
        }
        return retailers;
    }
    public static Retailer findretailer(int retailerID) {
        for (Retailer ret: getAllretailers()) {
            if (ret.getretailerId() == (retailerID)) {
                return ret;
            }
        }
        return null;
    }

}
