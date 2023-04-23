package com.boots.config;

import org.springframework.context.annotation.Bean;
import javax.transaction.UserTransaction;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;
@Configuration
public class TransactionConfig {

    @Bean
    public UserTransaction userTransaction() throws Throwable {
        UserTransaction userTransaction = com.arjuna.ats.jta.UserTransaction.userTransaction();
        userTransaction.setTransactionTimeout(10000);
        return userTransaction;
    }

    @Bean
    public JtaTransactionManager transactionManager() throws Throwable {
        JtaTransactionManager transactionManager = new JtaTransactionManager();
        transactionManager.setTransactionManager(com.arjuna.ats.jta.TransactionManager.transactionManager());
        transactionManager.setUserTransaction(userTransaction());
        return transactionManager;
    }
}