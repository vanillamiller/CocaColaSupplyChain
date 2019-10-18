package domain;

import java.util.Currency;
import java.util.UUID;

public class Pallet extends Product implements Created {

    private int toid;


    public Pallet(UUID pid, Flavor flav){
        super(pid, flav);
    }

    public Pallet(Flavor flav, int toid){
        super(flav);
        this.toid=toid;

//        System.out.println("this is the class of pallet " + this.getClass());
    }



    //    public Pallet(Flavor flav){
//        super(flav);
//        //        UnitOfWork.getCurrent().registerNew(this);
//    }
    public int getTo(){
        return this.toid;
    }

    public void create() {
        UnitOfWork.getCurrent().registerNew(this);
    }

}
