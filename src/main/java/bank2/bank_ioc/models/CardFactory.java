package bank2.bank_ioc.models;

import org.springframework.stereotype.Component;

@Component
public class CardFactory {
    public Card createCard(double balance, Currency currency) {
        return switch (currency) {
            case USD -> new USDCard(balance);
            case EUR -> new EURCard(balance);
            case UAH -> new UAHCard(balance);
            default -> throw new IllegalArgumentException("Invalid currency type: " + currency);
        };
    }
}