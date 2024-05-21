package bank2.bank_ioc.service;

import bank2.bank_ioc.models.Currency;

public interface OperationsService {
    String PutMoney(double amount, Currency currency, String ID);
    String TakeMoney(double amount, Currency currency, String ID);
    String Exchange(double amount, Currency currencyTo, Currency currencyFrom, String ID);
    String Credit(double amount, Currency currency, String ID);
}
