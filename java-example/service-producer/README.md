## Producer service

Exemplo de um simples produtor de mensagens no kafka. 

### Como rodar o projeto

*Requisitos:*
 - Java 14

```
./gradlew bootRun
```

### Como enviar uma mensagem para o kafka

Basta enviar um POST para /orders.

Ex:
```sh
 curl -X POST "http://localhost:8080/orders" -H  "Content-Type: application/json" 
-d "{\"subject\":\"Simple message\",\"body\":\"This is a simple message sent to Kafka\"}"
```