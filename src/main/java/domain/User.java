package domain;

import mappers.TransactorMapper;

public class User {

    public static Transactor getUser(String username){

        return TransactorMapper.find(username);

    }

    public static Transactor getUser(int id){

        return TransactorMapper.find(id);

    }

}
