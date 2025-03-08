package bank2.bank_ioc.controllers;

import bank2.bank_ioc.models.Currency;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pavlushka_bank/operations")
public class OperationsServiceController {

    @PostMapping("/{ID}/put")
    public String PutMoney(double amount, Currency currency, @PathVariable String ID) {
        return PutMoney(amount, currency, ID);
    }
    @PostMapping("/{ID}/take")
    public String TakeMoney(double amount, Currency currency, @PathVariable String ID) {
        return TakeMoney(amount, currency, ID);
    }
    @PostMapping("/{ID}/exchange")
    public String Exchange(double amount, Currency currencyTo, Currency currencyFrom, @PathVariable String ID) {
        return Exchange(amount, currencyTo, currencyFrom, ID);
    }
    @PostMapping("/{ID}/credit")
    public String Credit(double amount, Currency currency, @PathVariable String ID) {
        return Credit(amount, currency, ID);
    }
}
