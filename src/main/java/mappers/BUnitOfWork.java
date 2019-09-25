package mappers;

import java.util.*;

public class BUnitOfWork {
    private static ThreadLocal current=new ThreadLocal();

    private List<Object> newObjects=new ArrayList<Object>();
    private List<Object> dirtyObjects=new ArrayList<Object>();
    private List<Object> deletedObjects=new ArrayList<Object>();

    public static void newCurrent(){ setCurrent(new BUnitOfWork()); }

    public static void setCurrent(BUnitOfWork uow){ current.set(uow); }

    public static BUnitOfWork getCurrent(){ return (BUnitOfWork) current.get(); }

    public void registerNew(Object obj){

    }
}