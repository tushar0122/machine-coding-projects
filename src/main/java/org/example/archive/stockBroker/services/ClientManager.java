package org.example.archive.stockBroker.services;

import org.example.archive.stockBroker.entities.Client;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientManager {

    Map<String, Client> clientData = new ConcurrentHashMap<String, Client>();
    private static ClientManager clientManager;

    private ClientManager() {
    }

    public static ClientManager getInstance(){
        if(clientManager == null){
            clientManager = new ClientManager();
        }
        return clientManager;
    }

    public void createClient(String clientId, String clientName, int capital) {
        Client client = new Client(clientId, clientName, capital);
        clientData.put(client.getId(), client);
    }

    public Client getClient(String clientId) {
        return clientData.get(clientId);
    }

    public void printClientHoldings(String clientId){
        var holdings = clientData.get(clientId).getHoldings();
        for(var holding: holdings.entrySet()){
            System.out.println("Stock: "+holding.getKey()+" Quantity: "+holding.getValue());
        }
    }

    public void printAllClientHoldings(){
        for(var clientId: clientData.keySet()){
            printClientHoldings(clientId);
        }
    }

}
