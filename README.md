# Rental Events API — Sistema de Gestão e Locação de Equipamentos para Eventos

<div align="center">

![Java](https://img.shields.io/badge/Java_17-0057FF?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot_3-161B22?style=for-the-badge&logo=springboot&logoColor=6DB33F)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-161B22?style=for-the-badge&logo=postgresql&logoColor=4169E1)
![Swagger/OpenAPI](https://img.shields.io/badge/OpenAPI_3-161B22?style=for-the-badge&logo=swagger&logoColor=85EA2D)
![REST API](https://img.shields.io/badge/API-RESTful-161B22?style=for-the-badge&logo=fastapi&logoColor=009688)

**API RESTful para controle de inventário de equipamentos para eventos, usuários e registro de movimentações de locação.**

</div>

---

## 📋 Visão Geral do Projeto

O **Rental Events** é uma API REST desenvolvida em **Java 17** com **Spring Boot 3** e **PostgreSQL** para digitalizar e automatizar a logística de empresas de locação de infraestrutura para eventos (sistemas de som, painéis de LED, iluminação cênica, geradores e estruturas metálicas).

A aplicação assegura rastreabilidade total do ciclo de vida da locação, desde o cadastro do equipamento até sua saída, alocação a um cliente/evento e posterior devolução com conferência de estado.

---

## 🏗️ Arquitetura e Padrões de Projeto

O projeto foi estruturado seguindo o padrão de **Arquitetura em Camadas (Layered Architecture)**, garantindo baixo acoplamento, alta coesão e facilidade de manutenção e testes:

```text
com.senai.backend.rental_events
├── configs/             # Configurações do OpenAPI / Swagger
│   └── Swagger.java
├── controllers/         # Endpoints REST e serialização JSON
│   ├── EquipamentoController.java
│   ├── MovimentacaoController.java
│   └── UsuarioController.java
├── models/              # Mapeamento Objeto-Relacional (ORM / JPA)
│   ├── Equipamento.java
│   ├── Movimentacao.java
│   └── Usuario.java
├── repositories/        # Acesso a dados via Spring Data JPA
│   ├── EquipamentoRepository.java
│   ├── MovimentacaoRepository.java
│   └── UsuarioRepository.java
├── services/            # Lógica de negócio e validações
│   ├── EquipamentoService.java
│   ├── MovimentacaoService.java
│   └── UsuarioService.java
└── RentalEventsApplication.java
```

---

## 🛠️ Stack Tecnológica

- **Linguagem:** Java 17 LTS
- **Framework:** Spring Boot 3.4.3
- **Camada Web:** Spring Web MVC
- **Persistência & ORM:** Spring Data JPA / Hibernate
- **Banco de Dados Principal:** PostgreSQL (porta 5433 / `db_postgres`)
- **Banco de Dados de Testes:** H2 Database (In-Memory)
- **Documentação Interativa:** SpringDoc OpenAPI 2.8.5 (Swagger UI)
- **Ferramenta de Build:** Apache Maven com Maven Wrapper (`mvnw`)

---

## 📡 Endpoints e Recursos da API

A documentação interativa completa de schemas e requisições está disponível via Swagger UI.

### 1. Equipamentos (`/equipamentos`)
- `GET /equipamentos` — Lista todos os equipamentos cadastrados no catálogo.
- `GET /equipamentos/{id}` — Retorna os dados detalhados de um equipamento específico.
- `POST /equipamentos` — Registra um novo equipamento (nome, tipo, valor, disponibilidade).
- `PUT /equipamentos/{id}` — Atualiza informações de cadastro do equipamento.
- `DELETE /equipamentos/{id}` — Remove o registro de um equipamento do catálogo.

### 2. Usuários (`/usuarios`)
- `GET /usuarios` — Retorna a listagem de clientes/produtores de eventos cadastrados.
- `GET /usuarios/{id}` — Busca um usuário por seu identificador único.
- `POST /usuarios` — Cadastra um novo cliente no sistema.
- `PUT /usuarios/{id}` — Atualiza os dados de contato e cadastro do usuário.
- `DELETE /usuarios/{id}` — Remove o cadastro de um usuário.

### 3. Movimentações (`/movimentacoes`)
- `GET /movimentacoes` — Consulta o histórico de movimentações (locações e devoluções).
- `GET /movimentacoes/{id}` — Busca detalhes de uma movimentação específica.
- `POST /movimentacoes` — Registra a saída de um equipamento para um evento ou sua devolução.
- `PUT /movimentacoes/{id}` — Atualiza status ou datas da movimentação.
- `DELETE /movimentacoes/{id}` — Remove um registro de movimentação.

---

## 🚀 Como Executar Localmente

### Pré-requisitos
- **Java 17 JDK** instalado e configurado nas variáveis de ambiente.
- **Git** instalado.
- Banco de dados **PostgreSQL** ativo.

### 1. Clonar o Repositório
```bash
git clone https://github.com/miguelarraes-a11y/Rental_Events.git
cd Rental_Events
```

### 2. Configurar o Banco de Dados
Edite o arquivo `rental_events/src/main/resources/application.properties` conforme seu ambiente PostgreSQL:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Executar o Backend
No diretório `rental_events/`:

#### No Windows:
```powershell
cd rental_events
.\mvnw.cmd spring-boot:run
```

#### No Linux / macOS:
```bash
cd rental_events
chmod +x ./mvnw
./mvnw spring-boot:run
```

### 4. Acessar a Documentação Swagger
Com o servidor rodando na porta padrão (`8080`), acesse no navegador:
```text
http://localhost:8080/rental-db/swagger-ui.html
```

---

## 🧪 Testes Automatizados

Para executar os testes unitários e de contexto com o Maven Wrapper:
```bash
.\mvnw.cmd test
```

---

<div align="center">
Desenvolvido por <strong>Miguel Campião Arraes</strong> • SENAI Petrópolis
</div>
