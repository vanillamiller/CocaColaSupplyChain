package domain;

import com.google.gson.Gson;

public class ProductAssembler {

    public static String serialize(Product p){
        Gson gson=new Gson();
        return gson.toJson(p);
    }

    public static Product deserialize(String p){
        Gson gson=new Gson();
        return gson.fromJson(p, Product.class);
    }

}
