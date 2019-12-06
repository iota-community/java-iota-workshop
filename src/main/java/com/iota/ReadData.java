package com.iota;

import java.io.IOException;
import java.util.List;

import org.iota.jota.IotaAPI;
import org.iota.jota.error.ArgumentException;
import org.iota.jota.model.Bundle;
import org.iota.jota.model.Transaction;

class ReadData {
    public static void main(String[] args)
            throws ArgumentException, IOException {

        // Connect to a node
        IotaAPI api = new IotaAPI.Builder()
            .protocol("https")
            .host("nodes.devnet.thetangle.org")
            .port(443)
            .build();

        // Define the bundle hash whose transactions you want to get
        String bundleHash = "HGRGBSAQSKSBCDCX9IFUKDWYTJDKEMHAKWH9LJ9JCBL9EWHLSZQZYQXDZKVICNZKWKKUNTD9OSLVVEGFA";

        // Get the transaction objects in the bundle
        try { 
            List<Transaction> response = api.findTransactionObjectsByBundle(bundleHash);
            Bundle bundle = new Bundle(response);
            
            // A message can be spread over multiple transactions, thus we need to read them all from a bundle
            System.out.println(bundle.getMessage());
         } catch (ArgumentException e) { 
            // Handle error
            e.printStackTrace(); 
         }
    }
}