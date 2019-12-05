package com.iota;

import java.util.ArrayList;
import java.util.List;

import org.iota.jota.IotaAPI;
import org.iota.jota.dto.response.GetBalancesAndFormatResponse;
import org.iota.jota.error.ArgumentException;
import org.iota.jota.utils.StopWatch;

/// https://github.com/iotaledger/iota-java/blob/dev/docs/iota-java/getBalanceAndFormat.md

class CheckBalance {
    public static void main(String[] args) throws ArgumentException {

        // Connect to a node
        IotaAPI api = new IotaAPI.Builder().protocol("https").host("nodes.devnet.thetangle.org").port(443).build();

        // The addresses (with checksum) whose balance you want to check
        List<String> addresses = new ArrayList<String>();
        addresses.add("LRAZGXSV9FPCOO9OIUYLRLHBUJSBCCDBZC9UBPNMHQAGGI9BODPVIBMVCIKNCFVWWSALEBQMCFINHIVV9D9LYEQXSA");

        // Define the security level of the address
        int securityLevel = 2;

        // Get the confirmed balance of the address
        try {
            GetBalancesAndFormatResponse response = api.getBalanceAndFormat(addresses, null, 100, 0, new StopWatch(), securityLevel);
            System.out.printf("Your balance is: %s", response.getTotalBalance());
        } catch (ArgumentException e) { 
            // Handle error
            e.printStackTrace(); 
         }
    }
}