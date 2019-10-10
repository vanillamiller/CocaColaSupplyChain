package mappers;

import domain.DC;
import domain.Transaction;
import domain.Transactor;

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
        for (Transaction tx : newObjects) {
            TransactionMapper.insert(tx);
        }
        for (Transactor t : dirtyObjects) {

        }
    }

}