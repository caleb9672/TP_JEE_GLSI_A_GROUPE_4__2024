package iai.glsi.Service;

import iai.glsi.Model.Client;
import iai.glsi.Model.Task;
import iai.glsi.Repository.ClientRepository;
import iai.glsi.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    // méthodes pour gérer les opérations sur les transactions
}