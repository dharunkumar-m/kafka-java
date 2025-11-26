# kafka-java
Kafka Java Client
 
Start Kafka:

sudo docker run -d \
  --name kafka \
  -p 9092:9092 \
  -p 9093:9093 \
  -e KAFKA_KRAFT_MODE="true" \
  -e KAFKA_PROCESS_ROLES=broker,controller \
  -e KAFKA_NODE_ID=1 \
  -e KAFKA_CONTROLLER_QUORUM_VOTERS=1@dharun-11772t:9093 \
  -e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092,CONTROLLER://0.0.0.0:9093 \
  -e KAFKA_LISTENER_SECURITY_PROTOCOL_MAP=PLAINTEXT:PLAINTEXT,CONTROLLER:PLAINTEXT \
  -e KAFKA_INTER_BROKER_LISTENER_NAME=PLAINTEXT \
  -e KAFKA_CONTROLLER_LISTENER_NAMES=CONTROLLER \
  -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://dharun-11772t:9092 \
  -e KAFKA_LOG_DIRS=/var/lib/kafka/data \
  -e KAFKA_AUTO_CREATE_TOPICS_ENABLE="true" \
  -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 \
  -e KAFKA_LOG_RETENTION_HOURS=168 \
  -e KAFKA_GROUP_INITIAL_REBALANCE_DELAY_MS=0 \
  apache/kafka:4.1.1

List Topics:

sudo docker exec -it kafka /opt/kafka/bin/kafka-topics.sh \
  --bootstrap-server dharun-11772t:9092 --list


Create Topic:

sudo docker exec -it kafka /opt/kafka/bin/kafka-topics.sh \
  --create --topic Topic-A --bootstrap-server dharun-11772t:9092
  
  
Produce Events:

sudo docker exec -it kafka /opt/kafka/bin/kafka-console-producer.sh \
  --topic Topic-A --bootstrap-server dharun-11772t:9092


Consume Events:

sudo docker exec -it kafka /opt/kafka/bin/kafka-console-consumer.sh \
  --topic Topic-A --from-beginning --bootstrap-server dharun-11772t:9092


https://www.instaclustr.com/education/apache-spark/running-apache-kafka-kraft-on-docker-tutorial-and-best-practices/#sec-3
