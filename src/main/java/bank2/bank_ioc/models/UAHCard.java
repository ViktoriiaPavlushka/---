package bank2.bank_ioc.models;
public class UAHCard extends Card {
    public UAHCard(double Balance) {
        super(Balance, Currency.UAH, 0, 1);
    }

    @Override
    void WriteCurrency() {
        System.out.println("You opened UAH card");
    }
}
