package domain;

import com.google.gson.*;

public class OrderAssembler {

    public static String serialize(Order order){
        Gson gson=new Gson();
        return gson.toJson(order);
    }

    public static Order deserialize(final String order){
        Gson gson=new Gson();
        return gson.fromJson(order, Order.class);
    }

}
