package bank2.bank_ioc.models;
public abstract class Card {
    double Balance;
    protected final String NumberOfCard;
    final Currency currency;
    final double Fee;
    protected double Arrears;
    protected static long Counter = 0;

    public Card(double Balance, Currency Currency, double Arrears, double Fee){
        this.Balance = Balance;
        this.currency = Currency;
        this.Arrears = Arrears;
        this.NumberOfCard = String.format("%016d", Counter++);
        this.Fee = Fee;
    }

    public Card(){
        this.Balance = 0;
        this.Fee = 0.01;
        this.currency = Currency.UAH;
        this.Arrears = 0;
        this.NumberOfCard = String.format("%016d", Counter++);
    }

    public double getBalance() {
        return Balance;
    }
    public double getFee() {
        return Fee;
    }
    public void setBalance(double Balance) {
        this.Balance = Balance;
    }
    public String getNumberOfCard() {
        return NumberOfCard;
    }
    public Currency getCurrency() {
        return currency;
    }
    public double getArrears() {
        return Arrears;
    }
    public void setArrears(double Arrears) {
        this.Arrears = Arrears;
    }
    public static void resetCounter() {
        Counter = 0;
    }
    abstract void WriteCurrency();
}




