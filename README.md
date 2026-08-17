# TaskFlow API

API REST para gerenciamento de tarefas, desenvolvida em Java com Spring Boot.

O projeto foi criado como parte dos meus estudos, com foco em aplicar de forma prática (e explicável) os principais fundamentos de uma API backend: arquitetura em camadas, persistência com JPA, containerização com Docker e boas práticas de versionamento.

---

## Tecnologias utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Web** — criação da API REST
- **Spring Data JPA** — persistência de dados
- **PostgreSQL** — banco de dados relacional
- **Docker / Docker Compose** — ambiente do banco de dados
- **Maven** — gerenciador de dependências e build
- **Lombok** — redução de código repetitivo (getters, setters, construtores)
- **Git e GitHub** — versionamento de código

---

## Sobre o projeto

O TaskFlow permite gerenciar tarefas com as seguintes informações:

- ID
- Título
- Descrição
- Status (`PENDING`, `IN_PROGRESS`, `COMPLETED`)
- Prioridade (`LOW`, `MEDIUM`, `HIGH`)
- Data de criação
- Prazo (data de vencimento)

## Funcionalidades planejadas

- [x] Estrutura inicial do projeto
- [x] Configuração do banco de dados com Docker
- [x] Entidade `Task` com status e prioridade
- [ ] Criar tarefa
- [ ] Listar tarefas
- [ ] Buscar tarefa por ID
- [ ] Atualizar tarefa
- [ ] Excluir tarefa
- [ ] DTOs de request e response
- [ ] Validação de dados
- [ ] Tratamento de exceções
- [ ] Testes automatizados

---

## Arquitetura

O projeto segue uma arquitetura em camadas:

```
Controller → Service → Repository → Banco de dados
```

| Camada | Responsabilidade |
|---|---|
| `controller` | Recebe as requisições HTTP |
| `service` | Contém as regras de negócio |
| `repository` | Acesso aos dados via JPA |
| `entity` | Representa as tabelas persistidas no banco |
| `dto` | Representa os dados que entram e saem da API |
| `enums` | Tipos controlados do domínio (status, prioridade) |
| `exception` | Tratamento centralizado de erros |
| `config` | Configurações gerais da aplicação |

---

## Como rodar o projeto localmente

### Pré-requisitos

- Java 21
- Maven
- Docker e Docker Compose

### Passo a passo

1. Clone o repositório:

git clone https://github.com/Thamires005/taskflow-api.git
cd taskflow-api

2. Suba o banco de dados PostgreSQL com Docker:
docker compose up -d


3. Rode a aplicação:
./mvnw spring-boot:run

4. A API estará disponível em:
http://localhost:8080

## Configuração do banco de dados

| Configuração | Valor |
|---|---|
| Banco | `taskflow_db` |
| Usuário | `taskflow_user` |
| Senha | `taskflow_password` |
| Porta | `5432` |

---

## Status do projeto

Em desenvolvimento — projeto de estudos, sendo construído e documentado etapa por etapa.

---

## Autora

Desenvolvido por **Thamires Silva** como parte do meu processo de aprendizado em desenvolvimento backend com Java.
