# Módulo4 - Kafka Consumers & Producer

Este projeto é uma aplicação backend construída com **Spring Boot**, **Kafka** e **Zookepper**

## Tecnologias Utilizadas

O projeto utiliza as seguintes tecnologias e ferramentas:

## Tecnologias Utilizadas

O projeto utiliza as seguintes tecnologias e ferramentas:

- ![Java](https://img.shields.io/badge/Java-blue?logo=java&logoColor=white) **Java**
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-brightgreen?logo=spring&logoColor=white) **Spring Boot**
- ![Docker](https://img.shields.io/badge/Docker-20.10-blue?logo=docker&logoColor=white) **Docker & Docker Compose**
- ![SonarQube](https://img.shields.io/badge/SonarQube-latest-4E9BCD?logo=sonarqube&logoColor=white) **SonarQube**
- ![Kafka](https://img.shields.io/badge/Apache%20Kafka-black?logo=apachekafka&logoColor=white) **Apache Kafka**
- ![Zookeeper](https://img.shields.io/badge/ZooKeeper-4B8BBE?logo=apache&logoColor=white) **Zookeeper**


## Pré-requisitos

Antes de executar o projeto, certifique-se de ter o seguinte instalado e configurado no seu sistema:

- **Docker** – Para criar e rodar os contêineres.
    - [Instalação do Docker](https://docs.docker.com/get-docker/)
- **Docker Compose** – Para orquestrar múltiplos contêineres.
    - [Instalação do Docker Compose](https://docs.docker.com/compose/install/)
- **Java 17** – Necessário para compilar e rodar a aplicação Spring Boot.
    - [Instalação do Java 17](https://adoptium.net/)
- **Maven 3.9+** – Para gerenciamento de dependências e build do projeto.
    - [Instalação do Maven](https://maven.apache.org/install.html)
- **Conta no Docker Hub** – Para enviar a imagem do Docker.
    - [Cadastro Docker Hub](https://hub.docker.com/)
- **SonarQube** (opcional) – Para análise de qualidade de código.
    - Pode ser rodado localmente via Docker ou acessado via servidor corporativo.
- **Git** – Para clonar o repositório e versionamento de código.
    - [Instalação do Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
- **Offset Explorer** – Para criar os tópicos e testar a aplicação
    - [Instalação do Offset Explorer](https://kafkatool.com/features.html)

## Como Executar o Projeto Localmente

Siga os passos abaixo para rodar a aplicação e todos os serviços dependentes.

### 1. Clonar o Repositório
```bash
git clone https://github.com/Trabalho-final-PMP/modulo4.git
cd modulo4
```

### 2. Rodar o docker-compose
Para rodar todos os container da aplicação, rode `docker-compose up --build`

>Se for necessário, você pode inspecionar os logs do container do app no aplicativo do Docker, ou rodando o comando `docker-compose logs -f app`

### Enviando a requisição
O sistema possui tópico de filas, que devem ter a seguinte estrutura:

`POST http://localhost:8080/modulo4/v1/fila`

```JSON
{
  "tipo": "ENVIAR_EMAIL",
  "payload": "{\"email\":\"cliente@example.com\",\"mensagem\":\"Olá! Obrigado pela compra.\"}"
}

```

## Status

![Build Status](https://github.com/Trabalho-final-PMP/modulo4/actions/workflows/build.yml/badge.svg?branch=main)

![Docker Image](https://img.shields.io/docker/pulls/gabrielmendes21/modulo4)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Trabalho-final-PMP_modulo4&metric=alert_status)](https://sonarcloud.io/dashboard?id=Trabalho-final-PMP_modulo4)