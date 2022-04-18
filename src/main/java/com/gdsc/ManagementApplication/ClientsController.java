package com.gdsc.ManagementApplication;

import Classes.Client;
import Classes.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/clients")

public class ClientsController {
    static final List<Client> clients = new ArrayList<Client>();

    @PostMapping()
    public Client AddClient(@RequestBody Client client, HttpServletResponse response){
        if (client.isEmail(client.email) == false || client.isPhone(client.phone) == false) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }

        clients.add(client);
        return client;
    }

    @GetMapping()
    public List<Client> GetClients(){
        return clients;
    }

    @GetMapping("/{id}")
    public Client GetClientById(@RequestParam String id){
        Client client = Client.findById(clients, id);
        return client;
    }

    @PutMapping()
    public Client UpdateClient(@RequestBody Client client, @RequestParam String id){
        Client destinationClient = Client.findById(clients, id);
        Client.copyClient(client, destinationClient);
        return destinationClient;
    }

    @DeleteMapping()
    public Client DeleteClient(@RequestParam String id){
        Client client = Client.findById(clients, id);
        clients.remove(client);
        return client;
    }

    @PatchMapping("/{id}")
    public User ChangeContactPerson(@RequestBody User newClient, @RequestParam String id){
        Client client = Client.findById(clients, id);
        client.contactPerson = newClient;
        return client.contactPerson;
    }
}
