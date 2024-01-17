package glsi.SalleA.Service;
import glsi.SalleA.Model.Client;
import glsi.SalleA.Model.Task;
import glsi.SalleA.Repository.ClientRepository;
import glsi.SalleA.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    // méthodes pour gérer les opérations sur les transactions
}