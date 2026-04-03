# API de Gerenciamento de Usuários

API REST desenvolvida com Java e Spring Boot, com autenticação baseada em JWT e integração com PostgreSQL.

## 🚀 Tecnologias

- Java 17
- Spring Boot
- Spring Security
- JWT
- PostgreSQL
- JPA / Hibernate

## 🔐 Funcionalidades

- Cadastro de usuários
- Login com autenticação JWT
- Criptografia de senha com BCrypt
- Proteção de rotas
- CRUD completo
- Validação de dados
- Tratamento global de exceções

## 📌 Endpoints

### Auth
POST /auth/login

### Users
GET /users  
POST /users  
PUT /users/{id}  
DELETE /users/{id}

## ▶️ Como rodar o projeto

1. Clonar repositório
2. Configurar banco PostgreSQL
3. Ajustar application.properties
4. Rodar aplicação

## 🔑 Autenticação

Utilizar token JWT no header:

Authorization: Bearer SEU_TOKEN