package com.bank.springAngular.service;


import com.bank.springAngular.model.Account;
import com.bank.springAngular.model.Customer;
import com.bank.springAngular.repository.AccountRepository;
import com.bank.springAngular.repository.CardRepository;
import com.bank.springAngular.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

/**
 * Couche de service pour la gestion des opérations liées aux account.
 */
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CardRepository cardRepository;


    /**
     * Ajoute un nouveau account.
     *
     * @param account account à ajouter.
     * @return Le account ajouté.
     */
    public Account saveAccount(Account account, int customer_id) {

        Customer customer = customerRepository.findById(customer_id).get();
        account.setAccountName("CIH");


        account.setAccountNumber(Integer.valueOf(generateAccountNumber()));
        account.setCreationDate(new Date(System.currentTimeMillis()));
        account.setIsClosed(Boolean.valueOf("false"));
        account.setBalance(1000);
        account.setCustomer(customer);
        return accountRepository.save(account);
    }
    public String generateAccountNumber() {
        return UUID.randomUUID().toString().replace("-","").substring(0,16);
    }
    /**
     * Récupère tous les account associés à un utilisateur .
     *
     * @param cu_id Le id de customer pour lequel récupérer les comptes.
     * @return Liste les comptes associés au customer donné.
     */
    public List<Account> getAllAccounts(int cu_id) {
        return accountRepository.findByCustomerId(cu_id);}




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