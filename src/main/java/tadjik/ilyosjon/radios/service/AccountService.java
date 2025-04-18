package tadjik.ilyosjon.radios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.radios.dto.AccountDto;
import tadjik.ilyosjon.radios.model.Account;
import tadjik.ilyosjon.radios.model.Result;
import tadjik.ilyosjon.radios.repository.AccountRepo;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepo accountRepo;

    public List<Account> findAll() {
        return accountRepo.findAll();
    }

    public Account findById(Integer id) {
        return accountRepo.findById(id).get();
    }

    public Result create(AccountDto accountDto) {
        Account account = new Account();
        account.setName(accountDto.getName());
        account.setEmail(accountDto.getEmail());
        account.setPassword(accountDto.getPassword());
        accountRepo.save(account);
        return new Result(true, "Account created");
    }

    public Result update(Integer id, AccountDto accountDto) {
        Optional<Account> accountOptional = accountRepo.findById(id);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            account.setName(accountDto.getName());
            account.setEmail(accountDto.getEmail());
            account.setPassword(accountDto.getPassword());
            accountRepo.save(account);
            return new Result(true, "Account updated");
        }
        return new Result(false, "Account not found");
    }

    public Result delete(Integer id) {
        accountRepo.deleteById(id);
        return new Result(true, "Account deleted");
    }



}
