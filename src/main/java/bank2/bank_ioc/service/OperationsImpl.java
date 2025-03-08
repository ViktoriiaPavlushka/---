package bank2.bank_ioc.service;

import bank2.bank_ioc.models.Account;
import bank2.bank_ioc.models.Card;
import bank2.bank_ioc.models.Currency;
import bank2.bank_ioc.repository.AccountRepository;
import bank2.bank_ioc.repository.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationsImpl implements OperationsService{
    ExchangeRate exchangeRate;
    private final AccountRepository repository;
    @Autowired
    public OperationsImpl(ExchangeRate exchangeRate, AccountRepository repository){
        this.exchangeRate = exchangeRate;
        this.repository = repository;
    }

    public String PutMoney(double amount, Currency currency, String ID) {
        Account user = repository.Get(ID);
        if (user == null) {
            throw new IllegalArgumentException("Account with ID " + ID + " does not exist");
        }
        Card targetCard = user.getCards().get(currency);
        if (targetCard != null) {
            double newBalance = targetCard.getBalance() + amount;
            targetCard.setBalance(newBalance);
            return "Your balance now: " + targetCard.getBalance();
        } else {
            return "This card doesn't exist.";
        }
    }

    public String TakeMoney(double amount, Currency currency, String ID){
        Account user = repository.Get(ID);
        Card targetCard = user.getCards().get(currency);
        double Fee = amount*targetCard.getFee();
        if (targetCard != null) {
            if(targetCard.getBalance() >= amount) {
                targetCard.setBalance(targetCard.getBalance() - amount - Fee);
                return "Your balance now: " + targetCard.getBalance();
            }else{
                return "You can`t do this operation.";
            }
        } else {
            return "This card doesn`t exist ";
        }
    }

    public String Exchange(double amount, Currency currencyFrom, Currency currencyTo, String ID) {
        Account user = repository.Get(ID);
        if (user == null) {
            throw new IllegalArgumentException("Account with ID " + ID + " does not exist");
        }

        Card sourceCard = user.getCards().get(currencyFrom);
        if (sourceCard == null) {
            return "Source card doesn't exist.";
        }

        if (sourceCard.getBalance() < amount) {
            return "Insufficient balance on source card.";
        }

        Card targetCard = user.getCards().get(currencyTo);
        if (targetCard == null) {
            return "Target card doesn't exist.";
        }

        double amountInTargetCurrency = amount * exchangeRate.GetRate(currencyFrom, currencyTo);
        sourceCard.setBalance(sourceCard.getBalance() - amount);
        targetCard.setBalance(targetCard.getBalance() + amountInTargetCurrency);

        return "Exchange completed successfully. Balance of " + currencyFrom + " card: " + sourceCard.getBalance() +
                ", Balance of " + currencyTo + " card: " + targetCard.getBalance();
    }
    public String Credit(double amount, Currency currency, String ID) {
        Account user = repository.Get(ID);
        Card targetCard = user.getCards().get(currency);
        if (targetCard != null) {
            targetCard.setArrears(targetCard.getArrears() + amount);
            PutMoney(amount, currency, ID);
            return "Your arrears now: " + targetCard.getArrears();
        } else {
            return "This card doesn`t exist";
        }
    }
}
