package bank2.bank_ioc;

import bank2.bank_ioc.models.Account;
import bank2.bank_ioc.models.Card;
import bank2.bank_ioc.models.Currency;
import bank2.bank_ioc.repository.AccountRepository;
import bank2.bank_ioc.service.AccountManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AccountManagerTest {
    private AccountRepository repository;
    private AccountManager manager;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(AccountRepository.class);
        manager = new AccountManager(repository);
    }

    @Test
    void openAccount_createsNewAccount() {
        // Reset the Counter to a known value
        Card.resetCounter();

        Account account = new Account("Vika", "Pavlushka", 1000, Currency.USD);
        when(repository.Add(any(Account.class))).thenReturn(account);

        Account result = manager.OpenAccount("Vika", "Pavlushka", 1000, Currency.USD);

        assertEquals(account.getName(), result.getName());
        assertEquals(account.getSurName(), result.getSurName());
        assertEquals(account.getCards().keySet(), result.getCards().keySet());
        for (Currency key : account.getCards().keySet()) {
            assertEquals(account.getCards().get(key).getBalance(), result.getCards().get(key).getBalance());
        }
        verify(repository, times(1)).Add(any(Account.class));
    }

    @Test
    void getAccount_returnsExistingAccount() {
        Account account = new Account("Vika", "Pavlushka", 1000, Currency.USD);
        when(repository.Get("1")).thenReturn(account);

        Account result = manager.GetAccount("1");

        assertEquals(account, result);
        verify(repository, times(1)).Get("1");
    }

    @Test
    void removeAccount_removesExistingAccount() {
        doNothing().when(repository).Remove("1");

        manager.RemoveAccount("1");

        verify(repository, times(1)).Remove("1");
    }

    @Test
    void addAccount_addsNewAccount() {
        Account account = new Account("Vika", "Pavlushka", 1000, Currency.USD);
        when(repository.Add(any(Account.class))).thenReturn(account);

        manager.AddAccount(account);

        verify(repository, times(1)).Add(account);
    }

    @Test
    void getAllAccounts_returnsAllAccounts() {
        Account account1 = new Account("Vika", "Pavlushka", 1000, Currency.USD);
        Account account2 = new Account("John", "Doe", 2000, Currency.EUR);
        List<Account> accounts = Arrays.asList(account1, account2);
        when(repository.getAll()).thenReturn(accounts);

        List<Account> result = manager.GetAllAccounts();

        assertEquals(accounts, result);
        verify(repository, times(1)).getAll();
    }
}
