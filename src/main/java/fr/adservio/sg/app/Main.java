package fr.adservio.sg.app;

import fr.adservio.sg.app.exception.AccountException;
import fr.adservio.sg.model.Account;
import fr.adservio.sg.service.AccountService;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws Exception {

        Account account = new Account("Houssem ben chikha", new BigDecimal(500));

        // initial balance
        account.depositMoney(new BigDecimal(50));

        account.depositMoney(new BigDecimal(1000));

        account.depositMoney(new BigDecimal(3000));
        try {
            account.withdrawMoney(new BigDecimal(7000));
        } catch (AccountException e) {
            System.err.println(e.getMessage());
        }

        AccountService accountService = new AccountService();
        System.out.println(accountService.retrieveOperationsStatement(account.getOperations()));

    }

}
