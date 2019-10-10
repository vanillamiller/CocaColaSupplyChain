package mappers;

import domain.Transactor;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public abstract class TransactorMapper {

    public abstract Transactor find(int id);

    public abstract List<? extends Transactor> findAll();

    public abstract boolean update(Transactor t);

}
