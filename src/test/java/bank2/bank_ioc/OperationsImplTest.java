package bank2.bank_ioc;

import bank2.bank_ioc.models.Account;
import bank2.bank_ioc.models.Currency;
import bank2.bank_ioc.repository.AccountRepository;
import bank2.bank_ioc.repository.ExchangeRate;
import bank2.bank_ioc.service.OperationsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OperationsImplTest {
    private ExchangeRate exchangeRate;
    private AccountRepository repository;
    private OperationsImpl operations;

    @BeforeEach
    void setUp() {
        exchangeRate = mock(ExchangeRate.class);
        repository = mock(AccountRepository.class);
        operations = new OperationsImpl(exchangeRate, repository);
    }

    @Test
    void putMoney_addsMoneyToExistingCard() {
        Account account = new Account("Vika", "Pavlushka", 1000, Currency.USD);
        when(repository.Get(anyString())).thenReturn(account);

        String result = operations.PutMoney(500, Currency.USD, "0000000001");

        assertEquals("Your balance now: 1500.0", result);
    }

    @Test
    void putMoney_returnsErrorForNonExistingCard() {
        when(repository.Get(anyString())).thenReturn(null);

        assertThrows(IllegalArgumentException.class, () -> operations.PutMoney(500, Currency.EUR, "123"));
    }

    @Test
    void takeMoney_subtractsMoneyFromExistingCard() {
        Account account = new Account("Vika", "Pavlushka", 1000, Currency.USD);
        when(repository.Get(anyString())).thenReturn(account);

        String result = operations.TakeMoney(500, Currency.USD, "123");

        assertEquals("Your balance now: 485.0", result);
    }


    @Test
    void exchange_exchangesMoneyBetweenCards() {
        Account account = new Account("Vika", "Pavlushka", 1000, Currency.USD);
        account.NewCard(1000, Currency.UAH);
        when(repository.Get(anyString())).thenReturn(account);
        when(exchangeRate.GetRate(any(Currency.class), any(Currency.class))).thenReturn(1.0);

        String result = operations.Exchange(500, Currency.USD, Currency.UAH, "123");

        assertEquals("Exchange completed successfully. Balance of USD card: 500.0, Balance of UAH card: 1500.0", result);
    }

    @Test
    void credit_addsArrearsToExistingCard() {
        Account account = new Account("Vika", "Pavlushka", 1000, Currency.USD);
        when(repository.Get(anyString())).thenReturn(account);

        String result = operations.Credit(500, Currency.USD, "123");

        assertEquals("Your arrears now: 500.0", result);
    }
}
