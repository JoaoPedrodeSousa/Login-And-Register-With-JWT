# Login API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

Essa API foi projetada e desenvolvida utilizando Java, oferecendo endpoints que viabilizam o registro e a autenticação de usuários. Por meio dessa API, os usuários podem efetuar o cadastro e validar suas informações.

`TECNOLOGIAS UTILIZADAS:` **Java, Spring Boot, PostgreSQL, Spring Security e Json Web Token (JWT).**

## Instalação

1. Clone o repoitório para sua máquina local:

```bash
git clone https://github.com/JoaoPedrodeSousa/Api-Login.git
```

2. Instale as dependências utilizando Maven;
3. Instale o banco de dados PostgreSQL;
4. Crie um database com o nome LoginAPI, conforme abaixo:

```SQL
CREATE DATABASE LoginAPI;
```

5. Execute o projeto.

## Configuração

A API requer as seguintes variáveis de ambiente para funcionar corretamente:

`PORT: 8080`: Porta na qual o servidor será executado.

`PORT: 5432`: Porta na qual o Banco de Dados será executado.

## Endpoints

A API possui os seguintes endpoints disponíveis:

- `POST /register`: Registra novos usuários;

```bash
    POST http://localhost:8080/auth/register
    {
        "username" : "Fulano de tal",
        "password" : "123456789"
    }
```

- `POST /login`: Loga usuários autenticados no sistema;

```bash
    POST http://localhost:8080/auth/login
    {
        "username" : "Fulano de tal",
        "password" : "123456789"
    }
```

## Segurança e Autenticação

- `Autenticação baseada em token`: Foi utilizado `Json Web Token` (JWT) para autenticar solicitações. Os tokens são armazenados em cookies;
- `Criptografia BCrypt:` Método de criptografia do tipo hash para senhas.
