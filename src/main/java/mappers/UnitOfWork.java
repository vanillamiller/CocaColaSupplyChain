package mappers;

import domain.*;
import domain.external.Retailer;
import domain.internal.DC;

import java.util.*;
import java.lang.*;

public class UnitOfWork {
    private static ThreadLocal current=new ThreadLocal();

    private List<Transaction> newObjects=new ArrayList<Transaction>();
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

        for (Transaction tx : newObjects) {
            TransactionMapper.insert(tx);
        }
        for (Transactor t : dirtyObjects) {
            if (t.getClass()== DC.class){
                new DCMapper().update(t);
            } else if (t.getClass()== Retailer.class){
                new RetailerMapper().update(t);
            }
        }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}