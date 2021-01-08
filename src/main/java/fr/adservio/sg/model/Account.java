package fr.adservio.sg.model;

import fr.adservio.sg.app.exception.AccountException;
import fr.adservio.sg.enums.OperationType;
import fr.adservio.sg.enums.ResultType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Account {
    private String client;
    private BigDecimal balance = BigDecimal.ZERO;
    private List<Operation> operations;
    private BigDecimal amountOverdraftAuthorized;

    public Account(String client, BigDecimal amountOverdraftAuthorized) {
        this.client = client;
        this.amountOverdraftAuthorized = amountOverdraftAuthorized;
    }


    public synchronized void depositMoney(BigDecimal amount) {
        this.balance = this.balance.add(amount);
        addOperation(new Operation(OperationType.DEPOSIT, new Date(), amount, this.balance, ResultType.ACCEPTED));
    }


    public synchronized void withdrawMoney(BigDecimal amount) throws AccountException {
        if (this.getBalance().add(this.amountOverdraftAuthorized).add(amount.negate()).signum() < 0) {
            addOperation(new Operation(OperationType.WITHDRAWAL, new Date(), amount, this.balance, ResultType.REJECTED));
            throw new AccountException("Solde insuffisant !!!");
        } else {
            this.balance = this.balance.add(amount.negate());
            addOperation(new Operation(OperationType.WITHDRAWAL, new Date(), amount, balance, ResultType.ACCEPTED));

        }
    }

    private void addOperation(Operation operation) {
        if (this.operations == null) {
            operations = new ArrayList();
        }
        operations.add(operation);
    }
}
