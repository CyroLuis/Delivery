# Delivery
API de delivey para treinar API REST FULL

# 📦 Delivery API

API RESTful para gestão de delivery (Clientes, Produtos e Pedidos), desenvolvida para estudo de Backend.

## 🚀 Tech Stack
* **Java 17** + **Spring Boot 3**
* **Spring Data JPA** (Hibernate)
* **MySQL**
* **Lombok** & **Bean Validation**

## ⚙️ Como Rodar

1. **Pré-requisitos:** Java 17, Maven e MySQL.
2. **Banco de Dados:** Crie um banco chamado `delivery`.
   Aqui tens uma versão mais direta e resumida para o teu README.md:

Markdown

# 📦 Delivery API

API RESTful para gestão de delivery (Clientes, Produtos e Pedidos), desenvolvida para estudo de Backend.

## 🚀 Tech Stack
* **Java 17** + **Spring Boot 3**
* **Spring Data JPA** (Hibernate)
* **MySQL**
* **Lombok** & **Bean Validation**

## ⚙️ Como Rodar

1. **Pré-requisitos:** Java 17, Maven e MySQL.
2. **Banco de Dados:** Crie um banco chamado `delivery`.
    * *Credenciais padrão configuradas:* `root` / `@Angela2025` (ajuste no `application.properties` se necessário).
3. **Executar:**
   ```bash
   mvn spring-boot:run
🔌 Endpoints Principais
Clientes: GET /cliente/all, POST /cliente/save, DELETE /cliente/delete/{id}

Produtos: GET /produtos/all, POST /produtos/save, PUT /produtos/update/{id}, DELETE /produtos/delete/{id}

Pedidos: POST /pedidos/save, GET /pedidos/buscapedido/{id}, PATCH /pedidos/{id}/status