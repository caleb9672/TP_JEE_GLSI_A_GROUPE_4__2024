package iai.glsi.Controller;



import iai.glsi.Model.Compte;
import iai.glsi.Model.Client;
import iai.glsi.Service.ClientService;
import iai.glsi.Service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/comptes")
public class CompteController {
    @Autowired
    private CompteService compteService;
    @Autowired
    private ClientService clientService;

    // endpoints pour gérer les comptes
    @GetMapping
    public List<Compte> getAllComptes() {
        return compteService.getAllComptes();
    }

    @GetMapping("/{IdCompte}")
    public Compte getClientById(@PathVariable long IdCompte) {
        return compteService.getCompteById(IdCompte);
    }

   @GetMapping("/client/{IdClient}")
   public ResponseEntity<List<Compte>> getComptesByClientId(@PathVariable long IdClient) {
        List<Compte> comptes = compteService.getComptesByClientId(IdClient);

        return ResponseEntity.ok(comptes);
    }


    @PostMapping("/creer")
    public ResponseEntity<Compte> creerCompte(@RequestParam String numeroCompte, @RequestParam Long idClient) {
        // Récupérez le client associé à l'ID du propriétaire (vous devez avoir une méthode dans le service client pour cela)

        Client client = clientService.getClientById((long) idClient);
        // Créez le compte
        Compte nouveauCompte = compteService.createCompte(numeroCompte, client);
        return new ResponseEntity<>(nouveauCompte, HttpStatus.CREATED);
    }
}



