package bank2.bank_ioc.repository;

import bank2.bank_ioc.models.Currency;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class ExchangeRateRepository
{
    Map<Currency, Double> mapFromUAH = new HashMap<>();
    Map<Currency, Double> mapToUAH = new HashMap<>();
    public ExchangeRateRepository() {
        mapFromUAH.put(Currency.USD, 1 / 39.0);
        mapFromUAH.put(Currency.EUR, 1 / 42.0);
        mapFromUAH.put(Currency.UAH, 1.0);

        mapToUAH.put(Currency.USD, 39.0);
        mapToUAH.put(Currency.EUR, 42.0);
        mapToUAH.put(Currency.UAH, 1.0);
    }
    public double GetRate(Currency currency1, Currency currency2){

        Double conversionRateToUAH = mapToUAH.get(currency1);
        Double conversionRateFromUAH = mapFromUAH.get(currency2);
        return conversionRateToUAH * conversionRateFromUAH;
    }
}
