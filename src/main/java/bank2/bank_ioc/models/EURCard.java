package bank2.bank_ioc.models;
public class EURCard extends Card {
    public EURCard(double Balance) {
        super(Balance, Currency.EUR, 0, 0.03);
    }

    @Override
    void WriteCurrency() {
        System.out.println("You opened EUR card");
    }
}
