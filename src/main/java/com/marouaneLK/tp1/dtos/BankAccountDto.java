package com.marouaneLK.tp1.dtos;

import com.marouaneLK.tp1.enums.AccountType;
import lombok.Data;

import java.util.Date;

@Data
public class BankAccountDto {
    private Long id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
