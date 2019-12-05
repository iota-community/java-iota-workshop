package com.iota;

import org.zeromq.ZMQ;

public class ListenToZMQ {

    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.SUB);

        socket.connect("tcp://zmq.devnet.iota.org:5556");
        // Subscribe to all new transactions
        socket.subscribe("tx");
        // Subscribe to all confirmed transactions
        socket.subscribe("sn"); 

        while(true) {
            byte[] reply = socket.recv(0);
            String[] data = (new String(reply).split(" "));

            if(data[0].equals("tx")) System.out.println("NEW TRANSACTION" + "\n" + "Transaction hash: " + data[1] + "\n" + "Address: " + data[2] + "\n" + "Value: " + data[3] + "\n" + "Tag: " + data[4] + "\n");
            if(data[0].equals("sn")) System.out.println("CONFIRMED" + "\n" + "Transaction hash: " + data[2] + "\n" + "Address: " + data[3] + "\n");
        }
    }
}