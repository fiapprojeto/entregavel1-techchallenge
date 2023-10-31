# entregavel1-techchallenge

Projeto responsável pela geração de pedidos

![technology java](https://img.shields.io/badge/technology-Java-blue.svg)
![technology Gradle](https://img.shields.io/badge/technology-Gradle-blue.svg)

## Installation

- Pre-requesitos para iniciar o projeto
    - [**Java 17**](https://www.java.com/pt-BR/)
    - [**Gradle**](https://docs.gradle.org/current/userguide/userguide.html) | _or use the wrapper ./gradlew_
    - [**Spring Boot 3**](https://spring.io/projects/spring-boot)
    - [**Docker**](https://docs.docker.com/docker-for-mac/install/#download-docker-for-mac)

### Building

Execute o comando abaixo na raíz do projeto para buildar:

````
./gradlew clean build
````

### Running the tests

Execute o comando abaixo para executar os test da aplicação

```
./gradlew clean test
```

### Running the docker compose

```
docker compose up
```


### Documentation

Acesse o documentação do swagger do endereço abaixo:

```
http://localhost:8080/api-docs.html
```