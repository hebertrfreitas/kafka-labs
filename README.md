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


Listando tópicos
```sh
docker exec -t broker kafka-topics --bootstrap-server localhost:9092 --list
```






