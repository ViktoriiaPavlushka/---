package bank2.bank_ioc.models;


import java.util.HashMap;
import java.util.Map;

public class Account {
    Map<Currency, Card> cards = new HashMap<>();

    private String Name;
    private String Surname;
    private String ID;
    private static int count = 1;
    public Account(String Name, String Surname, double Balance, Currency currency){
        this.Name = Name;
        this.Surname = Surname;
        if (currency == Currency.USD) {
            Card cardUSD = new USDCard(Balance);
            cards.put(currency, cardUSD);
        }else if (currency == Currency.EUR) {
            Card cardEUR = new EURCard(Balance);
            cards.put(currency, cardEUR);
        }else{
            Card cardUAH = new UAHCard(Balance);
            cards.put(currency, cardUAH);
        }
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
        if (currency.equals(Currency.USD)) {
            Card cardUSD = new USDCard(Balance);
            cards.put(currency, cardUSD);
            System.out.println("Your card is done.");
            return cardUSD;
        }else if (currency.equals(Currency.EUR)) {
            Card cardEUR = new EURCard(Balance);
            cards.put(currency, cardEUR);
            System.out.println("Your card is done.");
            return cardEUR;
        }else{
            Card cardUAH = new UAHCard(Balance);
            cards.put(currency, cardUAH);
            System.out.println("Your card is done.");
            return cardUAH;
        }

    }

}
