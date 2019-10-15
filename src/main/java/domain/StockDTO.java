package domain;


import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class StockDTO {

    private String name;
    private int numVanilla, numRegular, numZero;
    private double pricer, pricev, pricez;

    public StockDTO(int nv, int nr, int nz, double pv, double pr, double pz){

        this.numRegular=nr;
        this.pricer=pr;
        this.pricez=pz;
        this.pricev=pv;
        this.numVanilla=nv;
        this.numZero=nz;
    }

    public static void toJson(StockDTO sdto){
        Gson gson= new Gson();
        gson.toJson(sdto);
    }

    public static StockDTO fromJson(JsonElement json){
        Gson gson=new Gson();
        return gson.fromJson(json, StockDTO.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public double getPricer() {
        return pricer;
    }

    public void setPricer(double pricer) {
        this.pricer = pricer;
    }

    public double getPricev() {
        return pricev;
    }

    public void setPricev(double pricev) {
        this.pricev = pricev;
    }

    public double getPricez() {
        return pricez;
    }

    public void setPricez(double pricez) {
        this.pricez = pricez;
    }
}
