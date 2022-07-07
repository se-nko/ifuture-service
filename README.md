# Demo for iFuture

### Стэк
- Java 13
- Spring Boot
- Embedded PostgreSQL

### Команда запуска
```
mvn clean install
java -jar service-1.jar
```

### Swagger UI
${host:localhost}:${port:8080}/service/swagger-ui/index.html

### Properties
- server.port: Порт сервиса
- statistic.performance.time-unit: единица времени измерения производительности запросов в мс default 60000
