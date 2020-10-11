# Projeto client de API REST - cotacao-dolar 
Projeto Desafio Tecnico Desenvolvedor Senior

Este projeto implementa um client que consulta a cotação do dólar comercial de uma determinada data a ser informada na requisição e armazena em banco de dados PostgreSQL.

A consulta é feita na API de cotação do dólar comercial do [Banco Central do Brasil](https://dadosabertos.bcb.gov.br/dataset/dolar-americano-usd-todos-os-boletins-diarios).

O projeto foi gerado executando na linha de comando (CMD):

```
mvn io.quarkus:quarkus-maven-plugin:1.8.3.Final:create -DprojectGroupId=br.com.bb.cotacaodolar -DprojectArtifactId=cotacao-dolar -DclassName="br.com.bb.cotacaodolar.GreetingResource" -Dpath="/cotacao-dolar"
```

Este projeto utiliza [Quarkus](https://quarkus.io/).

## Importe o projeto na IDE Eclipse

1. Faça download do projeto na sua workspace (área de trabalho)
2. Importe o projeto no Eclipse como um "existing maven project" (projeto maven existente)

```
File > Import... > Maven > Existing Maven Projects
```
3. Executar clean install

## Executando a aplicação em modo dev

É possível executar a aplicação em modo dev, que permite codificar em tempo real, assim:

```
./mvnw quarkus:dev
```

## Empacotando e executando a aplicação

A aplicação pode ser empacotada executando  `./mvnw package`.
Isso gera o arquivo `cotacao-dolar-1.0-SNAPSHOT-runner.jar` no diretório `/target` .
Esteja ciente de que não é um _über-jar_, ou seja, um "over-jar", um nível acima de um JAR simples, definido como aquele que contém seu pacote e todas as suas dependências em um único arquivo JAR, pois as dependências são copiadas para o diretório `target / lib`.

O aplicativo agora pode ser executado usando `java -jar target / cotacao-dolar-1.0-SNAPSHOT-runner.jar`.

## Criação de um executável nativo

Você pode criar um executável nativo usando: `./mvnw package -Pnative`.

Ou, se você não tem GraalVM instalado, você pode executar a compilação do executável nativo em um contêiner usando: `./mvnw package -Pnative -Dquarkus.native.container-build = true`.

Você pode então executar seu executável nativo com: `. / Target / cotacao-dolar-1.0-SNAPSHOT-runner`

Se você quiser saber mais sobre como construir executáveis ​​nativos, consulte o [Guia do Quarkus](https://quarkus.io/guides/building-native-image).
