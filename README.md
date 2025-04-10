# 📚 Sistema de Gerenciamento de Livros

Um sistema simples para gerenciar livros com cache em memória, desenvolvido em Spring Boot.


#### Métodos Principais
| Método | Descrição |
|--------|-----------|
| `findAll()` | Retorna todos os livros do banco |
| `getLivroInfo(id)` | Busca um livro específico (usa cache) |
| `updateLivroInfo(livroDTO)` | Atualiza um livro existente |

### 🔄 Como o Cache Funciona

1. **Quando busca um livro:**
   - 🔍 Primeiro procura no cache
   - ✅ Se encontrar, retorna do cache
   - 🔄 Se não encontrar, busca no banco e salva no cache

2. **Quando atualiza um livro:**
   - 💾 Atualiza no banco de dados
   - 🔄 Atualiza também no cache
   - 🔒 Mantém os dados sincronizados


### Endpoints Disponíveis

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/livros` | Retorna todos os livros |
| GET | `/livros/{id}` | Retorna um livro específico |
| PUT | `/livros/{id}` | Atualiza um livro existente |
| GET | `/livros/cache` | Mostra o conteúdo do cache no console |

### 📝 Exemplos de Uso

#### 1. Buscar um livro
```http
GET http://localhost:8080/livros/1
```

#### 2. Atualizar um livro
```http
PUT http://localhost:8080/livros/1
Content-Type: application/json

{
    "nome": "Novo Nome do Livro"
}
```

#### 3. Ver todos os livros
```http
GET http://localhost:8080/livros
```

### 📡 Respostas da API

| Código | Descrição |
|--------|-----------|
| 200 OK | Operação realizada com sucesso |
| 500 Internal Server Error | Erro no servidor |

## 🛠️ Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## 📋 Pré-requisitos

- Java 21
- MySQL
- Maven

## 🔧 Configuração

1. Clone o repositório
2. Configure o banco de dados no `application.properties`
3. Execute o projeto:
```bash
mvn spring-boot:run
```

## 📝 Licença

Este projeto está sob a licença MIT. 
