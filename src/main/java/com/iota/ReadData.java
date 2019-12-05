package com.iota;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.iota.jota.IotaAPI;
import org.iota.jota.error.ArgumentException;
import org.iota.jota.model.Transaction;
import org.iota.jota.utils.TrytesConverter;

class ReadData {
    public static void main(String[] args)
            throws ArgumentException, JsonParseException, JsonMappingException, IOException {

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
            System.out.println(TrytesConverter.trytesToAscii(response.get(0).getSignatureFragments().substring(0,2186)));
         } catch (ArgumentException e) { 
            // Handle error
            e.printStackTrace(); 
         }
    }
}