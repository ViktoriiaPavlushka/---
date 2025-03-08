package bank2.bank_ioc.models;
public class USDCard extends Card {
    public USDCard(double Balance) {
        super(Balance, Currency.USD, 0, 0.03);
    }

    @Override
    void WriteCurrency() {
        System.out.println("You opened USD card");
    }
}
