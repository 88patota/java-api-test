# Teste Automação API - Java, Cucumber & RestAssured

Foi criado uma estrutura baseada em DTO's *(porém não apliquei o conceito totalmente)* para realização dos testes.
Foi pedido no mínimo 1 cenário de cada etapa do teste e optei por criar cenários de "caminho feliz".

## Arquitetura Projeto

```
├── README.md
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   └── resources
    └── test
        ├── java
        │   ├── runners
        │   │   └── TestRunner.java
        │   ├── stepDefinitions
        │   │   ├── GetSteps.java
        │   │   ├── PatchSteps.java
        │   │   └── PostSteps.java
        │   └── utils
        └── resources
            ├── cucumber.properties
            ├── features
            │   ├── CreateUser.feature
            │   ├── GetUser.feature
            │   └── UpdateUser.feature
            └── junit-platform.properties
``` 

## Clone Repo
Realizar o clone/fork do projeto

`git clone git@github.com:88patota/java-api-test.git`

### Instalação via IDE Eclipse
Importar projeto e selecionar `Existing Maven Project` e automaticamente ele irá baixar as dependências que estão no arquivo: `pom.xml`.

## Execução dos testes
### Execução de todos os cenários
Para executar todos os cenários de teste, basta clicar com o botão direito sobre o arquivo `TestRunner.java` e em seguida `Run as -> Junit Test`

### Execução manual por cenário
Para executar qualquer teste do projeto, basta clicar com o botão direito sobre qualquer arquivo da pasta `resources/features` e em seguida `Run As -> Cucumber Feature`