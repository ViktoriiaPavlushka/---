package bank2.bank_ioc.controllers;

import bank2.bank_ioc.models.Account;
import bank2.bank_ioc.service.AccountManager;
import org.springframework.web.bind.annotation.*;

import bank2.bank_ioc.models.Currency;
import java.util.List;

@RestController
@RequestMapping("/pavlushka_bank/account")
public class AccountManagerController {

    private final AccountManager accountManager;

    public AccountManagerController(AccountManager accountManager){
        this.accountManager = accountManager;
    }

    @GetMapping("/get/{ID}")
    public Account getAccount(@PathVariable String ID){
        return accountManager.GetAccount(ID);
    }
    @DeleteMapping("/delete/{ID}")
    public void removeAccount(@PathVariable String ID){
        accountManager.RemoveAccount(ID);
    }
    @GetMapping("/getAll")
    public List<Account> getAllAccounts(){
        return accountManager.GetAllAccounts();
    }
    @PostMapping("/add")
    public void addAccount(@RequestBody Account user){
        accountManager.AddAccount(user);
    }

    @PostMapping("/open_account")
    public Account openAccount(@RequestBody String Name, @RequestBody String Surname,
                               @RequestBody double Balance, @RequestBody Currency currency) {
        return accountManager.OpenAccount(Name, Surname, Balance, currency);
    }
}
