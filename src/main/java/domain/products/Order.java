package domain.products;

import mappers.UnitOfWork;

public class Order {

    private int numVanilla, numRegular, numZero;

    public Order(int numVanilla, int numRegular, int numZero){
        this.numRegular=numRegular;
        this.numVanilla=numVanilla;
        this.numZero=numZero;
    }

//    public process(){
//        UnitOfWork.getCurrent().registerNew(this);
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
