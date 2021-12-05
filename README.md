# Business Info API - Home Assignment

A Spring Boot API for retrieving business info.

## Application Bootstrapping and Tech used
This application was created using Spring Boot [initializer](https://start.spring.io).

- Java 11
- maven 
- lombok
- Swagger
- WebClient for calling fake API

## Running locally
### With java
Jar file can be created using command: `mvn package`, <br/>
and the API can be run with: `java -jar [jarFileInTargetFolder].jar `

_(Java 11 and mvn required)_

### With docker 
_(For convenience)_

```
docker build -t business .
docker run -p 8080:8080 business
 ```

Swagger can be accessed at: http://localhost:8080/swagger-ui.html 

## Tests
Tests can be run using `mvn test` or `mvn verify` command.

