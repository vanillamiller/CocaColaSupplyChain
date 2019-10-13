package domain.products;

import mappers.UnitOfWork;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Product> order=new ArrayList<Product>();
    private int receiver;

    public void add(Product p){
        this.order.add(p);
    }

    public void remove(Product p){ this.order.remove(p); }

    public List<Product> list(){
        return order;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReciever(int reciever) {
        this.receiver=reciever;
    }

}
