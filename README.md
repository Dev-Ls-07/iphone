# iphone

# 📌 Case Técnico – Cadastro de Chaves PIX

## 📖 Introdução

O **Pix** é um meio de pagamento instantâneo, disponível 24/7, com liquidação em tempo real. As transações podem ocorrer entre pessoas físicas, jurídicas e entes governamentais.

### 🔑 Chave Pix

Apelido da conta transacional para identificar o recebedor com:

- **Celular**: `+<código país><DDD><número com 9 dígitos>`
- **Email**: até 77 caracteres, contendo `@`
- **CPF**: 11 dígitos (sem pontos ou traços)
- **CNPJ**: 14 dígitos (sem pontos ou traços)
- **Chave Aleatória**: alfanumérica com 36 caracteres

Limites:
- **Pessoa Física**: até 5 chaves por conta
- **Pessoa Jurídica**: até 20 chaves por conta

---

## 🧩 Funcionalidade 1: Inclusão

### 🎯 Objetivo

Permitir a inclusão de chaves PIX, vinculadas à agência e conta do correntista.

### 📥 Dados de Entrada

| Campo                  | Tipo         | Obrigatório |
|-----------------------|--------------|-------------|
| TIPO CHAVE            | Texto (9)    | ✅          |
| VALOR CHAVE           | Texto (77)   | ✅          |
| TIPO CONTA            | Texto (10)   | ✅          |
| NÚMERO AGÊNCIA        | Numérico (4) | ✅          |
| NÚMERO CONTA          | Numérico (8) | ✅          |
| NOME CORRENTISTA      | Texto (30)   | ✅          |
| SOBRENOME CORRENTISTA | Texto (45)   | ❌          |

### ✅ Critérios de Aceite

1. Registro em banco de dados
2. Geração de `UUID` como identificador
3. Limitar 5 chaves por conta PF, 20 para PJ
4. Proibição de duplicidade no valor da chave
5. Registro de data e hora da inclusão
6. Validações específicas por tipo de chave (celular, email, cpf, etc)
7. Respeitar obrigatoriedade dos campos
8. Mensagens de erro descritivas
9. HTTP 200 com ID no corpo da resposta
10. HTTP 422 em caso de erro de validação

---

## 🔁 Funcionalidade 2: Alteração

### 🎯 Objetivo

Permitir alteração dos dados do correntista, **sem alterar a chave em si**.

### 📥 Dados de Entrada

| Campo                  | Tipo         | Obrigatório |
|-----------------------|--------------|-------------|
| ID                    | UUID         | ✅          |
| TIPO CONTA            | Texto (10)   | ✅          |
| NÚMERO AGÊNCIA        | Numérico (4) | ✅          |
| NÚMERO CONTA          | Numérico (8) | ✅          |
| NOME CORRENTISTA      | Texto (30)   | ✅          |
| SOBRENOME CORRENTISTA | Texto (45)   | ❌          |

### 📤 Dados de Saída

Todos os dados da chave, incluindo `DATA/HORA INCLUSÃO`.

### ✅ Critérios de Aceite

- ID, tipo e valor da chave não podem ser alterados
- Chaves inativadas não podem ser alteradas
- Validar campos conforme regras
- HTTP 200 com dados atualizados
- HTTP 422 para erro de validação
- HTTP 404 se ID não encontrado

---

## ❌ Funcionalidade 3: Deleção (opcional)

### 🎯 Objetivo

Inativar uma chave registrada, impedindo alterações e futuras consultas.

### 📤 Dados de Saída

Inclui `DATA/HORA INATIVAÇÃO`, além dos dados da chave.

### ✅ Critérios de Aceite

- Se já inativada, retornar HTTP 422 com mensagem
- Registrar data/hora da inativação
- HTTP 200 com payload completo

---

## 🔍 Funcionalidade 4: Consulta

### 🎯 Objetivo

Disponibilizar consulta de chaves por:

- 🔹 ID (**obrigatório** implementar)
- 🔹 Tipo de chave
- 🔹 Agência e Conta
- 🔹 Nome do Correntista
- 🔹 Data de Inclusão
- 🔹 Data de Inativação

### 📤 Dados de Saída

Todos os dados da chave (ID, tipo, valor, conta, nome, datas).

### ✅ Critérios de Aceite

- Permitir combinação de filtros (exceto com ID)
- Se ID for usado, nenhum outro filtro pode ser enviado (HTTP 422)
- Não permitir consulta combinada entre inclusão e inativação (HTTP 422)
- HTTP 404 se nenhum registro
- Campos nulos devem ser retornados como branco (`""`)

---

## 💻 Requisitos Técnicos

- Linguagem: **Preferencialmente Java**
- Frameworks: Spring Boot, Micronaut, Quarkus ou puro
- Banco de dados: livre (MySQL, PostgreSQL, MongoDB, H2 etc.)
- Gerenciador de dependência: Maven ou Gradle
- **Cobertura de testes unitários mínima de 90%**
- Versionamento: GitHub ou outro VCS
- Aplicar boas práticas e design patterns
- Aplicar práticas do **12 Factor App**  
  🔗 [12factor.net/pt_br](https://12factor.net/pt_br)

---

## 🚀 Apresentação

Tenha à disposição um client de APIs (ex: **Postman**) para demonstrar:

- Inclusão, alteração, consulta (e deleção se implementado)
- Validações, mensagens de erro e exemplos de uso
