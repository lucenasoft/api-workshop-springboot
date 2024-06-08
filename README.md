# Workshop

Esta API é projetada para gerenciar o cadastro de usuários, posts e comentários em um sistema. Ela fornece endpoints que permitem realizar operações como criar, recuperar, atualizar e excluir usuários, posts e comentários.

## Tabela de Conteúdos

- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Endpoints](#endpoints)

## Tecnologias Utilizadas

- Java
- Spring Framework
- MongoDB

## Endpoints

A seguir estão listados os endpoints disponíveis nesta API.

### PostController

#### `GET - /post/{id}`

Retorna as informações de um post específico.

#### `GET - /posts/titlesearch`

Realiza uma busca por título e retorna uma lista de posts correspondentes.

#### `GET - /posts/fullsearch`

Realiza uma busca abrangente e detalhada por parâmetros e retorna uma lista de posts correspondentes.

### UserController

#### `GET - /users`

Retorna uma lista de todos os usuários registrados.

#### `GET - /user/{id}`

Retorna as informações de um usuário específico.

#### `GET - /user/{id}/posts`

Retorna os posts associados a um usuário específico.

#### `POST - /user`

Cria um novo usuário com base nos dados fornecidos.

#### `DELETE - /user/{id}`

Remove um usuário específico.

#### `PUT - /user/{id}`

Atualiza as informações de um usuário específico.
