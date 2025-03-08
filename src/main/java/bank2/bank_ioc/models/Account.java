package bank2.bank_ioc.models;


import java.util.HashMap;
import java.util.Map;

public class Account {
    Map<Currency, Card> cards = new HashMap<>();

    private final String Name;
    private final String Surname;
    private final String ID;
    private final CardFactory cardFactory;
    private static int count = 1;
    public Account(String Name, String Surname, double Balance, Currency currency){
        this.Name = Name;
        this.Surname = Surname;
        this.cardFactory = new CardFactory();
        cards.put(currency, cardFactory.createCard(Balance, currency));
        this.ID = String.format("%010d", count++);

    }

    //геттери і сеттери

    public String getName() {
        return Name;
    }
    public String getSurName() {
        return Surname;
    }
    public String getID(){
        return ID;
    }
    public Map<Currency, Card> getCards() {
        return cards;
    }

    public String getSurname() {
        return Surname;
    }

    public Card NewCard(double Balance, Currency currency ){
        Card card = cardFactory.createCard(Balance, currency);
        cards.put(currency, card);
        return card;
    }

}
