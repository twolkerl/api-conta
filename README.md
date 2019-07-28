# api-conta

***Banco de dados utilizado***: MongoDB

## JSON:
```json
{
    "id": "String gerado automaticamente ao criar",
    "numero": "String -> Somente digitos e no máximo 6 caracteres",
    "agencia": "String -> Somente digitos e no máximo 4 caracteres",
    "cpf": "String -> Somente digitos e no máximo 11 caracteres",
    "status": "Boolean -> Default ativo",
    "dataCriacao": "LocalDate -> Data da criação do registro",
    "dataAtualizacao": "LocalDate -> Data de alteração"
}
```

## Métodos:

**GET:** /conta
>Lista todas contas cadastradas -> Possivel paginar

**GET:** /conta/{id}
>Retorna uma conta especifica pelo ID

**POST:** /conta
>Salva uma conta na base de dados

**PUT:** /conta/{id}
>Atualiza um conta

**DELETE:** /conta/{id}
>Faz o delete lógico da conta (status = false)
