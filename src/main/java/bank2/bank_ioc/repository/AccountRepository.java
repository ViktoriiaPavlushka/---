package bank2.bank_ioc.repository;

import bank2.bank_ioc.models.Account;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Repository
public class AccountRepository {
    private final HashMap<String, Account> accounts = new HashMap<>();

    public Account Get(String ID){
        return accounts.get(ID);
    }
    public void Remove(String ID){
        accounts.remove(ID);
    }
    public Account Add(Account user){
        return accounts.put(user.getID(), user);
    }
    public List<Account> getAll() {
        return new ArrayList<>(accounts.values());
    }

}
