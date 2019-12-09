# IOTA Workshop

Simple examples to help a developer work through interacting with the IOTA network.

## Prerequisites

To get started you need [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git) installed on your device.

You also need a Java development environment that uses the [Maven](https://maven.apache.org/download.cgi) build tool. If this is your first time using the Java client library, complete our [getting started guide](https://docs.iota.org/docs/client-libraries/0.1/getting-started/java-quickstart), and follow the instructions for installing the library with Maven.

## Getting started

To start playing with these examples run the following commands:

### Linux and macOS

```bash
git clone https://github.com/JakeSCahill/java-iota-workshop.git
cd java-iota-workshop
mvn clean install
mvn exec:java -Dexec.mainClass="com.iota.HelloWorld"
```

### Windows

```bash
git clone https://github.com/JakeSCahill/java-iota-workshop.git
cd java-iota-workshop
mvn clean install
mvn exec:java -D"exec.mainClass"="com.iota.HelloWorld"
```

You should receive a message, including the statistics of an IOTA node. This means you can explore and run the other examples.

## Examples included

Here are the other examples included:

### SendData

In this example, you send a "hello world" message in a zero-value [transaction](https://docs.iota.org/docs/getting-started/0.1/transactions/transactions). These transactions are useful for storing messages on the [Tangle](https://docs.iota.org/docs/getting-started/0.1/network/the-tangle) without having to send any [IOTA tokens](https://docs.iota.org/docs/getting-started/0.1/clients/token).

### ReadData

In this example, you get your transaction from the Tangle by connecting to a node and asking it to filter them by their [bundle](https://docs.iota.org/docs/getting-started/0.1/transactions/bundles) hash. Then, you decode the message in the transaction and print it to the console.

### GenerateAddress

In this example, you learn how to generate a new [address](https://docs.iota.org/docs/getting-started/0.1/clients/addresses) for a [seed](https://docs.iota.org/docs/getting-started/0.1/clients/seeds) with a given [security level](https://docs.iota.org/docs/getting-started/0.1/clients/security-levels).

### CheckBalance

In this example, you request the balance of IOTA tokens on addresses from a node.

### SendTokens

In this example, you send a micropayment of 1 IOTA by sending a transfer bundle to a node.

### ListenToZMQ

In this example, you listen to the Tangle for recent transactions by subscribing to the [zero message queue (ZMQ)](https://zeromq.org/) on nodes that run the [IRI node software](root://node-software/0.1/iri/introduction/overview.md).

## Contribution

Pull requests are welcome on master :smile:

### Work to be done

- Add complex application examples

