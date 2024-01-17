package iai.glsi.Controller;

import iai.glsi.Service.ClientService;
import iai.glsi.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    // endpoints pour gérer les transactions
}