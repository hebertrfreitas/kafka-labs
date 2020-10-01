## Estudos Kafka

Repositório criado com o objetivo de aprender mais sobre o Kafka


### Montagem do docker

A estrutura do arquivo `docker-compose.yaml` foi criada a partir dos exemplos da confluent. <br>
Mais referencias neste link: https://docs.confluent.io/current/quickstart/ce-docker-quickstart.html

Atualmente o docker-compose possui somente o kafka e o zookeper.

Para executar use: 
```sh
docker-compose up -d
``` 


### Iteragindo com o kafka

disclaimer: os comandos a seguir são executados externamente do container docker onde está sendo executado o kafka. <br>
Assum-se o nome `broker` para o container pois assim está definido no arquivo `docker-compose.yaml`



Listando tópicos
```sh
docker exec -t broker kafka-topics --bootstrap-server localhost:9092 --list
```

Criando tópico
```sh
docker exec -t broker kafka-topics --bootstrap-server localhost:9092 --create --replication-factor 1 --partitions 1 --topic EXAMPLE_TOPIC
````





