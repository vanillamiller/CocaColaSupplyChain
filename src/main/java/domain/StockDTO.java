package domain;


import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class StockDTO {

    private String name;
    private int numVanilla, numRegular, numZero;

    public StockDTO(Inventory inv) {
        this.numRegular = inv.num_regular();
        this.numVanilla = inv.num_vanilla();
        this.numZero = inv.num_zero();
    }
    public StockDTO() {
        this.numRegular = 0;
        this.numVanilla = 0;
        this.numZero = 0;
    }

    public static String toJson(String sdto) {
        Gson gson = new Gson();
        return gson.toJson(sdto);
    }

    public static StockDTO fromJson(JsonElement json) {
        Gson gson = new Gson();
        return gson.fromJson(json, StockDTO.class);
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public int getNumVanilla() {
        return numVanilla;
    }

    public void setNumVanilla(int numVanilla) {
        this.numVanilla = numVanilla;
    }

    public int getNumRegular() {
        return numRegular;
    }

    public void setNumRegular(int numRegular) {
        this.numRegular = numRegular;
    }

    public int getNumZero() {
        return numZero;
    }

    public void setNumZero(int numZero) {
        this.numZero = numZero;
    }
}