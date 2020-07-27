# lab-api

A aplicação consiste em uma API para manutenção de laboratórios e exames.

As seguintes funcionalidades foram desenvolvidas:

- Cadastrar um novo laborário;
- Obter uma lista de laboratórios ativos;
- Atualizar um laboratório existente;
- Remover logicamente um laboratório ativo;
- Cadastrar um novo exame;
- Obter uma lista de exames ativos;
- Atualizar um exame existente;
- Remover logicamente um exame ativo;
- Associar um exame ativo à um laboratório ativo;
- Desassociar um exame ativo de um laboratório ativo;
- endpoint que faz a busca por nome do exame e retorna todos os laboratorios associados a esse exame;
- Publicação do ambiente na Amazon AWS;
- Documentação da API;

# Tecnologias e frameworks utilizados

- Sprint Boot:
  Desenvolvimento da Aplicação

- Maven:
  Gerenciador de Pacotes

- H2:
  Banco de dados em memória

- Spring Data JPA:
  Para a camada de persistencia

- Swagger:
  Para documentar a API

- Postman:
  Para testes na API
 
- GIT:
  Para controle de versão.

- AWS:
  Publicado na Amazon AWS.

# Arquitetura criada:

- br.com.jantorno.labapi:
  contem a classe de inicial para iniciar a execução do projeto.

- br.com.jantorno.labapi.config:
  contem a classe com a configuração do swagger.

- br.com.jantorno.labapi.domain:
  pacote que contem as classes de model da aplicação (Laboratório e Exames).
 
- br.com.jantorno.labapi.handler:
  contem uma classe handler para lidar com exeptions.

- br.com.jantorno.labapi.repository:
  pacote que contem o padrão Repository para realizar a persistencia com o banco de dados.

- br.com.jantorno.labapi.resources:
  contem os controllers da aplicação, responsaveis pelo mapeamento dos recursos da API.

- br.com.jantorno.labapi.services:
  classes que contem a regra de negócio da aplicação.

- br.com.jantorno.labapi.services.exceptions:
  classes de exceptions.

# Acesso ao Swagger (Documentação da API)
  - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8080/swagger-ui.html

# Exemplos de Endpoints da API

- GET - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8080/laboratorios
  Retorna uma lista com informações de todos os laboratórios

- GET - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8080/laboratorios/1
  Retorna informações do laboratório de código 1

- GET - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8080/exames
  Retorna uma lista com informações de todos os exames

- GET - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8080/exames/1
  Retorna informações do exame de código 1

- POST - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8080/laboratorios
  Inclui um laboratorio:
  
  {
    "nome" : "Previlab",
    "endereco" : "Rua Professor Aquino Brandão, 547, São Paulo, SP"
  }

- POST - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8080/laboratorios
  Inclui um exame:
  
  
  


- PUT - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8080/clientes/1
  Atualiza o cliente de código 1.

- DELETE - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8080/cliente/1
  Exclui o cliente de código 1
  
- POST - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8080/1/pets
  Inclui um pet para o cliente de codigo 1

- GET - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8080/pets
  Retorna uma lista com informações de todos os pets

- GET - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8080/pets/1
  Retorna informações do pet de código 1

- PUT - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8080/pets/1
  Atualiza o cliente de código 1.

- DELETE - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8080/pets/1
  Exclui o pet de código 1
