# dio-spring
Cadastro de clientes com Spring | DIO

Utilizando os Design Patterns: Singleton, Strategy e Facade

Java | Spring | H2 | Lombok | Swagger | OpenFeign | ViaCep API

# Cadastro de clientes
`POST` `localhost:8080/clientes`
```json
{
  "nome": "julio",
  "endereco": {
    "cep": "01109010"
  }
}
```
`GET` `localhost:8080/clientes/1`
```json
{
  "id": 1,
  "nome": "julio",
  "endereco": {
    "cep": "01109-010",
    "logradouro": "Rua Pedro Vicente",
    "complemento": "",
    "unidade": "",
    "bairro": "Luz",
    "localidade": "São Paulo",
    "uf": "SP",
    "ibge": "3550308",
    "gia": "1004",
    "ddd": "11",
    "siafi": "7107"
  }
}
```
Integrando com a API [ViaCep](https://viacep.com.br), o CEP inserido é convertido no endereço do usuário.

Uso de camadas:
```
├───controller
│       ClienteController.java
│
├───model
│       Cliente.java
│       Endereco.java
│
├───repository
│       ClienteRepository.java
│       EnderecoRepository.java
│
└───service
    │   ClienteService.java
    │   ViaCepService.java
    │
    └───impl
            ClienteServiceImpl.java
```
