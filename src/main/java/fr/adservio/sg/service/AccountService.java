package fr.adservio.sg.service;

import java.util.List;

// on peut faire un service spring ici
public class AccountService {
    private static final String HEADER = "OPERATION  |DATE	         |Amount  |Balance  |State " + "\n";


    public String retrieveOperationsStatement(List operations) {
        StringBuilder sb = new StringBuilder(HEADER);
        operations.forEach(op -> sb.append(op.toString()));
        return sb.toString();
    }
}

