package com.bank.springAngular.service;


import com.bank.springAngular.enam.Statu;
import com.bank.springAngular.model.Account;
import com.bank.springAngular.model.Card;
import com.bank.springAngular.model.Customer;
import com.bank.springAngular.repository.AccountRepository;
import com.bank.springAngular.repository.CardRepository;
import com.bank.springAngular.repository.CustomerRepository;
import org.hibernate.validator.internal.constraintvalidators.bv.time.futureorpresent.FutureOrPresentValidatorForLocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

import static com.bank.springAngular.enam.Statu.block;

/**
 * Couche de service pour la gestion des opérations liées aux account.
 */
@Service
public class AccountService {
    @Autowired(required = true)
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private FutureOrPresentValidatorForLocalDate futureOrPresentValidatorForLocalDate;

    /**
     * Ajoute un nouveau account.
     *
     * @param account account à ajouter.
     * @return Le account ajouté.
     */
    public Account saveAccount(Account account, int customer_id) {
        Customer user = customerRepository.findById(customer_id).get();
        account.setAccountName("CIH");
        int random = (int)(Math.random() );
        int number = 11+random;
        account.setAccountNumber(random);
        account.setBalance(1000);
        account.setCustomer(user);
        return accountRepository.save(account);
    }
    /**
     * Récupère tous les account associés à un utilisateur .
     *
     * @param id Le id de customer pour lequel récupérer les comptes.
     * @return Liste les comptes associés au customer donné.
     */
    public List<Account> getAllAccounts(int id) {
        return accountRepository.findByCustomerId(id);}
        


//    public Account getAccountById(int id) {
//        return accountRepository.findById(id).get();
//    }

    /**
     *
     * @param accountid est id de account pour specifier le comptes spécifiques
     * @param raison est param pour specifie la raison de blockage
     * @return account blocked "isClosed='true'"
     */
    public Account updateClose(int accountid, String raison) {

        Account account = accountRepository.findById(accountid).orElse(null);

        if (account.getBalance() <= 0) {
            account.setRaisonMssg(raison);
            account.setIsClosed(true);
       if(account.getIsClosed() == true){
           cardRepository.deleteByAccountId(accountid);
       }

                return accountRepository.save(account);
            } else {
                throw new RuntimeException("withdraw your money");
            }

        }

    }