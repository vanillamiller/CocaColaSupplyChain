package domain;

public abstract class ExternalTransactor extends Transactor implements ClientEntity {
    public ExternalTransactor(int id, String name){
        super(id, name);
    }
}
