package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Barrel extends RawProduct implements Created {

    private int to;

    public Barrel(UUID pid, Flavor flav){
        super(pid, flav);
    }

    public Barrel(Flavor flav, int id){
        super(flav);
        this.to=id;
        this.create();
    }

    public List<Product> transform(){
        return new ArrayList<Product>(Collections.nCopies(100, new Pallet(this.getFlavor(), AppSession.getUser().getID())));
//        TODO barrel may need to be deleted
    }


    public void create() {
//        UnitOfWork.getCurrent().registerNew(this);
    }

    public int getTo(){
        return this.to;
    }

}
