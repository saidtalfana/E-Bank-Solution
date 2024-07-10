package com.bank.springAngular.service;

import com.bank.springAngular.model.Account;
import com.bank.springAngular.model.Beneficiary;
import com.bank.springAngular.model.Transaction;
import com.bank.springAngular.repository.AccountRepository;
import com.bank.springAngular.repository.BeneficiaryRepository;
import com.bank.springAngular.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import static com.bank.springAngular.enam.TransactionType.credit;
import static com.bank.springAngular.enam.TransactionType.debit;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private BeneficiaryService beneficiaryService;
    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    public Transaction saveTransaction(Transaction transaction, int accountid){
        Account account = accountRepository.findById(accountid).get();
       if( account.getBalance()<transaction.getAmount() && transaction.getTransactionType()==credit){
           throw new RuntimeException("your money is not enough");
       } else if (account.getBalance()>=transaction.getAmount()) {
         account.setBalance(account.getBalance()-transaction.getAmount());

       }
       else if(transaction.getTransactionType()==debit){
           account.setBalance(account.getBalance()+ transaction.getAmount());
       }
       transaction.setTransactionDate(new Date( System.currentTimeMillis()));
       transaction.setTime( new Time( System.currentTimeMillis()));
        transaction.setAccount(account);


        return transactionRepository.save(transaction);
    }


    public List<Transaction> allTransactions(){
        return transactionRepository.findAll();
    }
public  List<Transaction> getTransactionsByAccountId(int id){
        return transactionRepository.findByAccountId(id);
}
}
