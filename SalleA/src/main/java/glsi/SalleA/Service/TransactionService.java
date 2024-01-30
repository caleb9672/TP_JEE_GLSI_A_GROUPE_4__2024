package glsi.SalleA.Service;
import glsi.SalleA.Model.Transaction;
import glsi.SalleA.Model.Compte;
import glsi.SalleA.Repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(long idTransaction) {
        return transactionRepository.findById(idTransaction)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found with id: " + idTransaction));
    }

    public void deleteTransactionById(long idTransaction) {
        if (transactionRepository.existsById(idTransaction)) {
            transactionRepository.deleteById(idTransaction);
        } else {
            throw new EntityNotFoundException("Transaction not found with id: " + idTransaction);
        }
    }



    // méthodes pour gérer les opérations sur les transactions
}