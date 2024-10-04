package com.marouaneLK.tp1.entities;

import com.marouaneLK.tp1.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name = "p1")
public interface AccountProjection {
    Long getId();
    AccountType getType();
    Double getBalance();
}
