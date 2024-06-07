package bank2.bank_ioc.service;

import bank2.bank_ioc.models.Account;
import bank2.bank_ioc.models.Currency;
import bank2.bank_ioc.repository.AccountRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountManager {
    private final AccountRepository repository;

    public AccountManager(AccountRepository repository){
        this.repository = repository;
    }

    public Account OpenAccount(String Name, String Surname, double Balance, Currency currency){
        Account user = new Account(Name, Surname, Balance, currency);
        repository.Add(user);
        return user;
    }

    public Account GetAccount(String ID){
        return repository.Get(ID);
    }
    public void RemoveAccount(String ID){
        repository.Remove(ID);
    }
    public void AddAccount(Account user){
        repository.Add(user);
    }
    public List<Account> GetAllAccounts() {
        return repository.getAll();
    }

}
