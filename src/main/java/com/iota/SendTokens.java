package com.iota;

import java.util.ArrayList;

import org.iota.jota.IotaAPI;
import org.iota.jota.dto.response.SendTransferResponse;
import org.iota.jota.error.ArgumentException;
import org.iota.jota.model.Transfer;

class SendTokens {
    public static void main(String[] args) throws ArgumentException {

        // Connect to a node
        IotaAPI api = new IotaAPI.Builder()
            .protocol("https")
            .host("nodes.devnet.thetangle.org")
            .port(443)
            .build();
        
        int depth = 3;
        int minimumWeightMagnitude = 9;

        // Replace this seed with the one that owns the address you used to get free test tokens
        String mySeed = "JBN9ZRCOH9YRUGSWIQNZWAIFEZUBDUGTFPVRKXWPAUCEQQFS9NHPQLXCKZKRHVCCUZNF9CZZWKXRZVCWQ";

        // Define the security level of the seed's address from which you want to withdraw
        int securityLevel = 2;

        // Define an address to which to send IOTA tokens
        String address = "ZLGVEQ9JUZZWCZXLWVNTHBDX9G9KZTJP9VEERIIFHY9SIQKYBVAHIMLHXPQVE9IXFDDXNHQINXJDRPFDXNYVAPLZAW";
        // Define an input transaction object
        // that sends 1 i to your new address
        int value = 1;

        Transfer Transaction = new Transfer(address, value);
        
        ArrayList<Transfer> transfers = new ArrayList<Transfer>();

        transfers.add(Transaction);
        
        // Create a bundle from the transfers list
        // and send the transactions to the node
        try {
            System.out.printf("Sending 1 i to %s", address);
            SendTransferResponse response = api.sendTransfer(mySeed, securityLevel, depth, minimumWeightMagnitude, transfers, null, null, false, false, null);
            System.out.println(response.getTransactions());
        } catch (ArgumentException e) { 
            // Handle error
            e.printStackTrace(); 
         }
    }
}