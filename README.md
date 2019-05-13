# kafka
Simple demo with Spring support for Kafka

Install Kafka:
https://kafka.apache.org/quickstart

Create multi-broker cluster(3 nodes in our case)
Copy server-properties files:
copy config\server.properties config\server-1.properties
copy config\server.properties config\server-2.properties

Run servers:
bin\windows\kafka-server-start.bat config/server-1.properties
bin\windows\kafka-server-start.bat config/server-2.properties

Create topics:
bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 3 --partitions 1 --topic my-replicated-topic
bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 3 --partitions 5 --topic partitioned

Describe topic:
bin\windows\kafka-topics.bat --describe --bootstrap-server localhost:9092 --topic my-replicated-topic

Get consumer groups:
bin\windows\kafka-consumer-groups.bat --bootstrap-server localhost:9092 --list

View info about the consumer group:
bin\windows\kafka-consumer-groups.bat --bootstrap-server localhost:9092 --describe --group my-group