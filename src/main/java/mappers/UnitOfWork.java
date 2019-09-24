package mappers;
import com.sun.tools.javac.util.Assert;

//import java.util.*;
//
//public class UnitOfWork {
//    private static ThreadLocal current=new ThreadLocal();
//
//    private List<Object> newObjects=new ArrayList<Object>();
//    private List<Object> dirtyObjects=new ArrayList<Object>();
//    private List<Object> deletedObjects=new ArrayList<Object>();
//
//    public static void newCurrent(){ setCurrent(new UnitOfWork()); }
//
//    public static void setCurrent(UnitOfWork uow){ current.set(uow); }
//
//    public static UnitOfWork getCurrent(){ return (UnitOfWork) current.get(); }
//
//    public void registerNew(Object dobj){
//        Assert.notNull(dobj.getId(), "id is null", );
//    }
//
//}