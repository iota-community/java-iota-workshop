package com.iota;

import java.util.ArrayList;

import org.iota.jota.IotaAPI;
import org.iota.jota.dto.response.SendTransferResponse;
import org.iota.jota.error.ArgumentException;
import org.iota.jota.model.Transfer;
import org.iota.jota.utils.SeedRandomGenerator;
import org.iota.jota.utils.TrytesConverter;

class SendData {
    public static void main(String[] args) throws ArgumentException {

        // Connect to a node
        IotaAPI api = new IotaAPI.Builder()
            .protocol("https")
            .host("nodes.devnet.thetangle.org")
            .port(443)
            .build();

        int depth = 3;
        int minimumWeightMagnitude = 9;

        // Even though a seed is not necessary because zero value transactions are not signed,
        // the library requires a seed to send a transaction.
        // This seed can be any random string of 81 trytes
        String myRandomSeed = SeedRandomGenerator.generateNewSeed();

        // Define any security level (like the seed, this is not used)
        int securityLevel = 2;

        // Define an address.
        // This does not need to belong to anyone or have IOTA tokens.
        // It must only contain a maximum of 81 trytes
        // or 90 trytes with a valid checksum
        String address = "ZLGVEQ9JUZZWCZXLWVNTHBDX9G9KZTJP9VEERIIFHY9SIQKYBVAHIMLHXPQVE9IXFDDXNHQINXJDRPFDXNYVAPLZAW";
        // This is a zero-value transaction
        int value = 0;
        // Define a message to send.
        // This message must include only ASCII characters.
        String message = TrytesConverter.asciiToTrytes("Hello world");
        String tag = "HELLOWORLD";

        Transfer zeroValueTransaction = new Transfer(address, value, message, tag);
        
        ArrayList<Transfer> transfers = new ArrayList<Transfer>();

        transfers.add(zeroValueTransaction);
        
        // Create a bundle from the transfers list
        // and send the transaction to the node
        try { 
            SendTransferResponse response = api.sendTransfer(myRandomSeed, securityLevel, depth, minimumWeightMagnitude, transfers, null, null, false, false, null);
            System.out.println(response.getTransactions());
        } catch (ArgumentException e) { 
            // Handle error
            e.printStackTrace(); 
         }
    }
}