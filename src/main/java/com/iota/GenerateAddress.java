package com.iota;

import org.iota.jota.IotaAPI;
import org.iota.jota.builder.AddressRequest;
import org.iota.jota.dto.response.GetNewAddressResponse;
import org.iota.jota.error.ArgumentException;

class GenerateAddress {
public static void main(String[] args) throws ArgumentException {

        // Connect to a node
        IotaAPI api = new IotaAPI.Builder()
            .protocol("https")
            .host("nodes.devnet.thetangle.org")
            .port(443)
            .build();

        // The seed that will be used to generate an address
        String mySeed = "PUPTTSEITFEVEWCWBTSIZM9NKRGJEIMXTULBACGFRQK9IMGICLBKW9TTEVSDQMGWKBXPVCBMMCXWMNPDX";

        // Define the security level of the address
        int securityLevel = 2;

        // Generate an unspent address with security level 2
        // If this address is spent, this method returns the next unspent address with the lowest index
        try { 
            GetNewAddressResponse response = api.generateNewAddresses(new AddressRequest.Builder(mySeed, securityLevel).amount(1).checksum(true).build());
            System.out.printf("Your address is %s", response.getAddresses());
        } catch (ArgumentException e) { 
            // Handle error
            e.printStackTrace(); 
        }
    }
}