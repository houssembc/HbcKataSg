package fr.adservio.sg.model;

import fr.adservio.sg.app.exception.AccountException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;


public class AccountTest {

    @Test(expected = AccountException.class)
    public void testInvalidWithDraw() throws AccountException {
        Account account = new Account("Houssem ben chikha", new BigDecimal(500));
        account.depositMoney(new BigDecimal(100));
        account.withdrawMoney(new BigDecimal(20000));
    }

    @Test
    public void testValidWithDraw() throws AccountException {

        Account account = new Account("Houssem ben chikha", new BigDecimal(500));
        account.depositMoney(new BigDecimal(500));
        account.withdrawMoney(new BigDecimal(800));
        Assertions.assertEquals(account.getBalance(), new BigDecimal(300).negate());
    }


    @Test
    public void testValidDeposit() {
        Account account = new Account("Houssem ben chikha", new BigDecimal(500));
        account.depositMoney(new BigDecimal(500));
        account.depositMoney(new BigDecimal(500));
        Assertions.assertEquals(account.getBalance(), new BigDecimal(1000));
    }
}
