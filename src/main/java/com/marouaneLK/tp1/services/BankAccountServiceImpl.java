package com.marouaneLK.tp1.services;

import com.marouaneLK.tp1.dtos.BankAccountDto;
import com.marouaneLK.tp1.entities.BankAccount;
import com.marouaneLK.tp1.mappers.BankAccountMapper;
import com.marouaneLK.tp1.repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountRepository accountRepository;
    private final BankAccountMapper bankAccountMapper;

    @Override
    public BankAccountDto saveAccount(BankAccountDto account) {
        account.setCreatedAt(new Date());
        return bankAccountMapper.toBankAccountDto(accountRepository
                .save(bankAccountMapper.toBankAccount(account)));
    }

    @Override
    public BankAccountDto getAccount(Long id) {
        return bankAccountMapper.toBankAccountDto(accountRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Account not found")));
    }

    @Override
    public List<BankAccountDto> getAccounts() {
        return bankAccountMapper.toBankAccountDtoList(
                accountRepository.findAll()
        );
    }

    @Override
    public BankAccountDto updateAccount(BankAccountDto account, long id) {
        BankAccount bankAccount = accountRepository.findById(id).get();
        if(bankAccount != null) {
            if(account.getBalance() != null && account.getBalance() != bankAccount.getBalance()) {
                bankAccount.setBalance(account.getBalance());
            }
            if(account.getCurrency() != null && account.getCurrency() != bankAccount.getCurrency()) {
                bankAccount.setCurrency(account.getCurrency());
            }
            return bankAccountMapper.toBankAccountDto(accountRepository.save(bankAccount));
        }
        throw new RuntimeException("Bank account not found");
    }

    @Override
    public String deleteAccount(Long id) {
        accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not found"));
        accountRepository.deleteById(id);
        return "Bank account deleted";
    }
}
