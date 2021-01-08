package fr.adservio.sg.model;

import fr.adservio.sg.enums.OperationType;
import fr.adservio.sg.enums.ResultType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Operation {

    private OperationType type;
    private Date date;
    private BigDecimal amount;
    private BigDecimal balance;
    private ResultType resultType;
}
