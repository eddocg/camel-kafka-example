# Camel Kafka example

## Introduction

An example which shows how to integrate Camel with Kafka.

This project consists of the following examples:

  1. This example requires that Kafka Server is up and running.

## Preparing Kafka

This example requires that Kafka Server is up and running.

```
    ${KAFKA}/bin/zookeeper-server-start.sh ${KAFKA}/config/zookeeper.properties

    ${KAFKA}/bin/kafka-server-start.sh ${KAFKA}/config/server.properties
```

You will need to create following topics before you run the examples.

On windows run

    ${KAFKA}/bin/kafka-topics.bat --create --zookeeper <zookeeper host ip>:<port> --replication-factor 1 --partitions 1 --topic my-topic

On linux run

    ${KAFKA}/bin/kafka-topics.sh --create --zookeeper <zookeeper host ip>:<port> --replication-factor 1 --partitions 1 --topic my-topic

## Build

You will need to compile this example first:
```
    $ mvn compile
```
## Run

Run the consumer first in separate shell
```
    $ mvn spring-boot:run
```
camel-context.xml file has both kafka-producer and kafka-consumer routes defined to produce/consume messages to topic my-topic.

Press `Ctrl-C` to exit.

## Configuration

You can configure the details in the file:
```
 src/main/resources/application.properties`
```
