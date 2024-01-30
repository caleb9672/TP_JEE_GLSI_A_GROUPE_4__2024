package glsi.SalleA.Controller;

import glsi.SalleA.Model.Compte;
import glsi.SalleA.Model.Transaction;
import glsi.SalleA.Service.ClientService;
import glsi.SalleA.Service.CompteService;
import glsi.SalleA.Service.TransactionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CompteService compteService;
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{IdTransaction}")
    public Transaction getTransactionByIdById(@PathVariable long IdTransaction) {
        return transactionService.getTransactionById(IdTransaction);
    }

    @DeleteMapping("/{idTransaction}")
    public ResponseEntity<String> deleteCompte(@PathVariable Long idTransaction) {
        try {
            transactionService.deleteTransactionById(idTransaction);
            return new ResponseEntity<>("Transaction deleted successfully", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Transaction not found with id: " + idTransaction, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting the Transaction", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // endpoints pour gérer les transactions
}