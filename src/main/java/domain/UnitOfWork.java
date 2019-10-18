package domain;

import java.util.*;
import java.lang.*;

public class UnitOfWork {
    private static ThreadLocal current=new ThreadLocal();


    private List<Created> newObjects=new ArrayList<Created>();
    private List<Transactor> dirtyObjects=new ArrayList<Transactor>();
    private List<Transactor> deletedObjects=new ArrayList<Transactor>();

    public static void newCurrent(){ setCurrent(new UnitOfWork()); }

    public static void setCurrent(UnitOfWork uow){ current.set(uow); }

    public static UnitOfWork getCurrent(){ return (UnitOfWork) current.get(); }

    public void registerNew(Transaction tx){
        assert !dirtyObjects.contains(tx);
        assert !deletedObjects.contains(tx);
        assert !newObjects.contains(tx);
        newObjects.add(tx);
    }

    public void registerNew(Pallet p){
        assert !dirtyObjects.contains(p);
        assert !deletedObjects.contains(p);
        assert !newObjects.contains(p);
        newObjects.add(p);
    }

    public void registerDirty(Transactor t) {
        assert !deletedObjects.contains(t);

        if (!dirtyObjects.contains(t) && !newObjects.contains(t))
            dirtyObjects.add(t);

    }

    public void registerDeleted(Transactor t) {
        if (newObjects.remove(t))
            return;

        dirtyObjects.remove(t);

        if (!deletedObjects.contains(t))
            deletedObjects.add(t);

    }

    public void commit() {
        try{

            for (Created c : newObjects) {
                if(c instanceof Transaction)
                    TransactionMapper.insert(c);
                if(c instanceof Barrel)
                    ProductMapper.insert(c);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}