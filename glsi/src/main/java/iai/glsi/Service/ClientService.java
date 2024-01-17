package iai.glsi.Service;

import iai.glsi.Model.Client;
import iai.glsi.Model.Compte;
import iai.glsi.Repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }
    public Client getClientById(long idClient) {
        return clientRepository.findById(idClient).orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + idClient));
    }

    public Client createClient(String name, String prenom, String sexe, Date dateNaissance) {
        Client client = new Client();
        client.setName(name);
        client.setPrenom(prenom);
        client.setDateNaissance(dateNaissance);
        client.setSexe(sexe);
        // Autres initialisations
        return clientRepository.save(client);
    }

    public void deleteClientById(Long idClient) {
        // Vérifier si le client existe avant de le supprimer
        if (clientRepository.existsById(idClient)) {
            clientRepository.deleteById(idClient);
        } else {
            throw new EntityNotFoundException("Client not found with id: " + idClient);
        }
    }

    // methodes pour gerer les opérations sur les clients


}