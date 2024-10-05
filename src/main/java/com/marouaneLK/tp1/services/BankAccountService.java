package com.marouaneLK.tp1.services;

import com.marouaneLK.tp1.dtos.BankAccountDto;

import java.util.List;

public interface BankAccountService {
    BankAccountDto saveAccount(BankAccountDto account);
    BankAccountDto getAccount(Long id);
    List<BankAccountDto> getAccounts();
    BankAccountDto updateAccount(BankAccountDto account, long id);
    String deleteAccount(Long id);
}
