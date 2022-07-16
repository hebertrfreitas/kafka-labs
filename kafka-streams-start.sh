docker exec -t broker kafka-topics --bootstrap-server localhost:9092 --create --replication-factor 1 --partitions 1 --topic streams-plaintext-input
docker exec -t broker kafka-topics --bootstrap-server localhost:9092 --create --replication-factor 1 --partitions 1 --topic streams-wordcount-output --config cleanup.policy=compact