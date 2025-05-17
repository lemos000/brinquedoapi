# Projeto Brinquedos API

- Samuel Patrick Yariwake RM556461
- Luiz Felipe Campos da Silva RM555591
- Gabriel Lemos da Silva RM554819

## Desenvolvido na IDE IntelliJ
![image](https://github.com/user-attachments/assets/7633b293-daa9-4acf-9612-5ca8d2dd3bc7)

## Tecnologias Utilizadas

* **Java:** Linguagem de programação principal.
* **Spring Boot:** Framework para desenvolvimento rápido de aplicações Java.
* **Spring Data JPA:** Simplifica o acesso e a persistência de dados com JPA.
* **JPA (Java Persistence API):** Especificação para gerenciamento de dados em aplicações Java.
* **Maven:** Ferramenta de automação de build.
* **IntelliJ IDEA:** Ambiente de desenvolvimento integrado utilizado.
* **Insomnia:** Cliente REST utilizado para testar os endpoints da API.
* **Banco de Dados:** Oracle

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter as seguintes ferramentas instaladas:

* **Java Development Kit (JDK):** Versão 21
* **Maven:** Versão 3.9
* **IntelliJ IDEA:** (Opcional, para desenvolvimento)
* **Insomnia ou outra ferramenta de teste de API:** (Opcional, para testar os endpoints)
* **Banco de Dados:** (Certifique-se de que o banco de dados configurado esteja em execução)

## Configuração do Projeto

1.  **Clone o repositório:**
    ```bash
    git clone [https://docs.github.com/en/repositories/archiving-a-github-repository/referencing-and-citing-content](https://docs.github.com/en/repositories/archiving-a-github-repository/referencing-and-citing-content)
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd projeto-brinquedos-api
    ```

3.  **Execute a aplicação Spring Boot:**
    Você pode executar a aplicação diretamente do IntelliJ IDEA ou utilizando o Maven:
    ```bash
    ./mvnw spring-boot:run
    ```

    Ou, se estiver no Windows:
    ```bash
    mvnw spring-boot:run
    ```

    A aplicação estará disponível em `http://localhost:8080` (a porta pode variar).

## Estrutura de Pastas

* **`br.com.fiap.brinquedoapi.operacao`**: Esta é a pasta raiz do pacote da aplicação.
    * **`controller`**: Esta pasta contém as classes responsáveis por receber as requisições externas (como requisições HTTP de um cliente).
    * **`domain`**: Esta pasta abriga as classes que representam as entidades de negócio da aplicação. Essas classes modelam os dados e conceitos chave do domínio do problema que a aplicação busca resolver.
        ### Resumo da Classe `Brinquedo` presente em domain

        A classe `Brinquedo` representa uma entidade de brinquedo no sistema, mapeada para a tabela `TB_BRINQUEDO` no banco de dados.

        **Atributos:**

        * `id`: Identificador único do brinquedo (chave primária, gerada automaticamente).
        * `nome`: Nome do brinquedo (obrigatório, máximo de 100 caracteres).
        * `tipo`: Tipo do brinquedo (obrigatório, máximo de 50 caracteres).
        * `classificacao`: ENUM, Classificação etária do brinquedo (obrigatória, representada por um enum `Classificacao`, máximo de 50 caracteres).
        * `tamanho`: Tamanho do brinquedo (opcional, máximo de 20 caracteres).
        * `preco`: Preço do brinquedo (obrigatório).

        **Anotações JPA:**

        * `@Entity`: Indica que esta classe é uma entidade JPA.
        * `@Table(name = "TB_BRINQUEDO")`: Especifica o nome da tabela no banco de dados.
        * `@Id`: Marca o atributo `id` como a chave primária.
        * `@GeneratedValue(strategy = GenerationType.AUTO)`: Define a estratégia de geração automática para a chave primária.
        * `@Column(nullable = false, length = ...)`: Define as restrições para as colunas no banco de dados (não nulo e tamanho máximo).
        * `@Enumerated(EnumType.STRING)`: Indica que o enum `Classificacao` será persistido como uma string no banco de dados.
    * **`repository`**: Esta pasta contém as interfaces ou classes responsáveis pela interação com a camada de persistência de dados (como um banco de dados), nesse caso, utilizando o `JpaRepository`.
    * **`services`**: Esta pasta contém as classes que implementam a lógica das requisições como salvar, deletar e pegar todos ou apenas um brinquedo(s).

Em resumo, esta estrutura de pastas organiza o código da aplicação em camadas lógicas, facilitando a manutenção, o entendimento e a escalabilidade do projeto.

## Projeto no Spring Initializr
![image](https://github.com/user-attachments/assets/f0fe75d8-de9a-4301-a6da-89bf003ebf2e)

## Endpoints da API

A API de Brinquedos oferece os seguintes endpoints:

* **`POST /api/brinquedos`**: Adiciona um novo brinquedo.
    * **Corpo da Requisição (JSON):**
        ```json
        {
            "nome": "Carrinho de Corrida",
            "tipo": "Veículo",
            "classificacao": "LIVRE",
            "tamanho": "Pequeno",
            "preco": 29.99
        }
        ```
    * **Resposta (JSON):** Retorna o brinquedo criado com um ID gerado.

* **`GET /api/brinquedos`**: Lista todos os brinquedos.
    * **Resposta (JSON):** Uma lista de objetos `Brinquedo`.

* **`GET /api/brinquedos/{id}`**: Busca um brinquedo pelo seu ID.
    * **Parâmetro:** `id` (identificador único do brinquedo).
    * **Resposta (JSON):** O objeto `Brinquedo` correspondente ao ID, ou um erro 404 se não encontrado.

* **`PUT /api/brinquedos/{id}`**: Atualiza um brinquedo existente.
    * **Parâmetro:** `id` (identificador único do brinquedo a ser atualizado).
    * **Corpo da Requisição (JSON):** Similar ao do `POST`, contendo os dados atualizados do brinquedo.
    * **Resposta (JSON):** O brinquedo atualizado, ou um erro 404 se não encontrado.

* **`DELETE /api/brinquedos/{id}`**: Exclui um brinquedo pelo seu ID.
    * **Parâmetro:** `id` (identificador único do brinquedo a ser excluído).
    * **Resposta:** Código de status 204 (No Content) em caso de sucesso, ou 404 se não encontrado.

## Exemplos no Insomnia:

![a](https://github.com/user-attachments/assets/dc983289-5512-4fdd-89f5-c17e774587b5)
**Exemplo de requisição GET para listar todos os brinquedos.**

![b](https://github.com/user-attachments/assets/6ff23551-37cf-4170-9183-fbafdd9ab842)
**Exemplo de requisição GET para buscar um brinquedo por ID.**

![c](https://github.com/user-attachments/assets/c3e22b16-609f-43ca-9787-5be93440a639)
**Exemplo de resposta da requisição POST, mostrando o brinquedo criado com o ID gerado.**

![d](https://github.com/user-attachments/assets/8501d13d-5107-4caf-a398-d31d72d25024)
**Exemplo de resposta da requisição PUT, mostrando o brinquedo alterado pelo ID.**

![e](https://github.com/user-attachments/assets/ac760369-8c40-4a57-8b2d-248929e94c31)
**Exemplo de requisição DELETE para excluir um brinquedo por ID.**

### Por que usar JpaRepository em vez de CrudRepository?

A escolha de `JpaRepository` em vez de `CrudRepository` no Spring Data JPA se deu pela **extensibilidade e funcionalidades adicionais** que o `JpaRepository` oferece!
