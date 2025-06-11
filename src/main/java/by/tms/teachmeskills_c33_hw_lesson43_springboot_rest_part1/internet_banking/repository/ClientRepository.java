package by.tms.teachmeskills_c33_hw_lesson43_springboot_rest_part1.internet_banking.repository;

import by.tms.teachmeskills_c33_hw_lesson43_springboot_rest_part1.internet_banking.model.Client;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ClientRepository {
    private Map<Long, Client> clients = new HashMap<>();

    public ClientRepository() {
        clients.put(1L, new Client(1L, "Марина"));
        clients.put(2L, new Client(2L, "Руслан"));
    }

     public Client getClientById(Long id) {
        return clients.get(id);
     }

     public Map<Long, Client> getAllClients(){
        return clients;
     }

     public void saveClient(Client client){
        clients.put(client.getId(), client);
     }
}
