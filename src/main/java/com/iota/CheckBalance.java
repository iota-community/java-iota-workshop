package com.iota;

import org.iota.jota.IotaAPI;
import org.iota.jota.error.ArgumentException;

class CheckBalance {
    public static void main(String[] args) throws ArgumentException {

        // Connect to a node
        IotaAPI api = new IotaAPI.Builder()
            .protocol("https")
            .host("nodes.devnet.thetangle.org")
            .port(443)
            .build();

        // The addresses (with checksum) whose balance you want to check
        String address= "LRAZGXSV9FPCOO9OIUYLRLHBUJSBCCDBZC9UBPNMHQAGGI9BODPVIBMVCIKNCFVWWSALEBQMCFINHIVV9D9LYEQXSA";

        // Get the confirmed balance of the address
        try {
            long balance = api.getBalance(100, address);
            System.out.printf("Your balance is: %s", balance);
        } catch (ArgumentException e) { 
            // Handle error
            e.printStackTrace(); 
        }
    }
}