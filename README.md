# kafka-producer

Spring Boot Application with Kafka Message Producer + Zookeeper

Producer basically prepares a `MessageObject(identifier=d7ea610b-9087-438c-9b52-1913a17ec2a9, action=SEND EMAIL)` and consumer can consume this message to perform certain tasks. 
Currently consumer only LOGS the message data.
Next step is to Containerize. 

*Note: Java 11 is required.

## Zookeeper Setup

1. Download and Unzip Zookeeper.
2. Goto `conf` directory. Then `cp zoo_sample.cfg zoo.cfg`
3. Optional: Change `dataDir` in the `zoo.cfg`, as default is pointed to `/tmp/data`.

## To start Zookeeper

1. Goto `bin` folder.
2. Execute `./zkServer.sh start`

## To stop Zookeeper

1. Goto `bin` folder.
2. Execute `./zkServer.sh stop`

## Kafka Setup

1. Download and Unzip Kafka.
2. Goto `config` folder and open `server.properties`.
3. Then uncomment `listeners=PLAINTEXT://:9092`. This will allow Kafka broker to listen on port 9092.
4. Optional: Change `log.dirs` in the `server.properties`.
5. Optional: `zookeeper.connect` in `server.properties` defines Zookeeper properties.

## To start Kafka

1. Goto `bin` folder.
2. Execute `./bin/kafka-server-start.sh config/server.properties`

## To stop Kafka

1. Goto `bin` folder.
2. Execute `./bin/kafka-server-stop.sh`

## To run Producer

execute `./gradlew bootRun` 

