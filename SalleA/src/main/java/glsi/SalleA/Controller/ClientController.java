package glsi.SalleA.Controller;

import glsi.SalleA.Service.ClientService;
import glsi.SalleA.Model.Client;
import glsi.SalleA.Model.Compte;
import glsi.SalleA.Service.ClientService;
import glsi.SalleA.Service.CompteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private CompteService compteService;

    // endpoints pour gérer les clients
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{IdClient}")
    public Client getClientById(@PathVariable int IdClient) {
        return clientService.getClientById(IdClient);
    }

    @PostMapping("/creer")
    public ResponseEntity<Client> creerCompte(@RequestParam String name, @RequestParam String prenom, @RequestParam String sexe, @RequestParam Date dateNaissance) {

        // Créez le client
        Client nouveauClient = clientService.createClient(name, prenom, sexe, dateNaissance);
        return new ResponseEntity<>(nouveauClient, HttpStatus.CREATED);
    }


    @DeleteMapping("/{idClient}")
    public ResponseEntity<String> deleteClient(@PathVariable Long idClient) {
        try {
            clientService.deleteClientById(idClient);
            return new ResponseEntity<>("Client deleted successfully", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Client not found with id: " + idClient, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting the client", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
