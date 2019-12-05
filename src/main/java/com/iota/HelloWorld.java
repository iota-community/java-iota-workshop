package com.iota;

import org.iota.jota.IotaAPI;
import org.iota.jota.dto.response.GetNodeInfoResponse;
import org.iota.jota.error.ArgumentException;

class HelloWorld {
public static void main(String[] args) throws ArgumentException {

        // Connect to a node
        IotaAPI api = new IotaAPI.Builder()
            .protocol("https")
            .host("nodes.devnet.thetangle.org")
            .port(443)
            .build();

        // Call the `getNodeInfo()` method for information about the node and the Tangle
        GetNodeInfoResponse response = api.getNodeInfo();
        System.out.println(response);
    }
}