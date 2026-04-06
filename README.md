# 🚀 API de Gerenciamento de Usuários

API REST desenvolvida com **Java e Spring Boot**, com autenticação baseada em **JWT**, criptografia de senha com **BCrypt** e integração com **PostgreSQL**.

Este projeto foi desenvolvido com foco em boas práticas de desenvolvimento backend, arquitetura em camadas e segurança de aplicações.

---

## 🧠 Objetivo do Projeto

O objetivo desta API é simular um sistema real de gerenciamento de usuários, implementando autenticação segura, controle de acesso e operações CRUD completas, seguindo padrões utilizados no mercado.

---

## 🛠️ Tecnologias Utilizadas

* Java 17
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* PostgreSQL
* Spring Data JPA (Hibernate)
* Maven

---

## 🧱 Arquitetura

O projeto segue o padrão de arquitetura em camadas:

```text
controller → service → repository → database
```

* **Controller**: responsável pelos endpoints da API
* **Service**: regras de negócio
* **Repository**: acesso ao banco de dados
* **Entity/DTO**: modelagem e transferência de dados

---

## 🔐 Funcionalidades

* Cadastro de usuários
* Login com autenticação JWT
* Criptografia de senha com BCrypt
* Proteção de rotas com Spring Security
* CRUD completo de usuários
* Validação de dados com DTOs
* Tratamento global de exceções

---

## 📌 Endpoints

### 🔑 Autenticação

**POST /auth/login**

```json
{
  "email": "ian@email.com",
  "password": "123456"
}
```

**Resposta:**

```json
{
  "token": "SEU_TOKEN_JWT"
}
```

---

### 👤 Usuários

#### Criar usuário

**POST /users**

```json
{
  "name": "Ian",
  "email": "ian@email.com",
  "password": "123456"
}
```

---

#### Listar usuários

**GET /users**

---

#### Buscar por ID

**GET /users/{id}**

---

#### Atualizar usuário

**PUT /users/{id}**

```json
{
  "name": "Ian Oliveira",
  "email": "ian@email.com",
  "password": "654321"
}
```

---

#### Deletar usuário

**DELETE /users/{id}**

---

## 🔒 Autenticação

Para acessar rotas protegidas, é necessário enviar o token JWT no header:

```text
Authorization: Bearer SEU_TOKEN
```

---

## ▶️ Como rodar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/ian-schmechel/user-api-springboot.git
```

---

### 2. Configurar o banco de dados

Crie um banco no PostgreSQL:

```sql
CREATE DATABASE userapi;
```

---

### 3. Configurar o application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/userapi
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 4. Rodar a aplicação

```bash
./mvnw spring-boot:run
```

Ou diretamente pela IDE.

---

## 🧪 Testes

Você pode testar a API utilizando:

* Postman
* Insomnia

Fluxo recomendado:

1. Criar usuário (`POST /users`)
2. Fazer login (`POST /auth/login`)
3. Copiar o token
4. Acessar rotas protegidas (`/users`)

---

## 📈 Possíveis melhorias futuras

* Implementação de roles (admin/user)
* Refresh Token
* Paginação e ordenação
* Documentação com Swagger/OpenAPI
* Deploy em cloud (AWS, Railway, Render)

---

## 🧑‍💻 Autor

**Ian Schmechel de Oliveira**

* GitHub: https://github.com/ian-schmechel
* Email: [ian.schmechelads@gmail.com](mailto:ian.schmechelads@gmail.com)

---

## 📌 Considerações finais

Este projeto demonstra a construção de uma API backend completa, com foco em segurança, organização de código e boas práticas amplamente utilizadas no desenvolvimento de sistemas modernos.
