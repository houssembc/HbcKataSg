package fr.adservio.sg.app.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AccountException extends Exception {

    public AccountException(String msg) {
        super(msg);
    }
}

