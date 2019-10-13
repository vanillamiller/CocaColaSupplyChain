package domain;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.*;
import domain.products.Order;
import domain.products.Product;

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
