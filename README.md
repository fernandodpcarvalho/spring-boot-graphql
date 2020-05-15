# Compras - API em Graphql com Spring

http://graphql.org/swapi-graphql

https://github.com/graphql/graphql-spec

https://github.com/prisma-labs/graphql-playground

https://github.com/rlechetaudemy/springboot_graphql

# Para rodar, digite o seguinte comando na pasta do projeto, onde se encontra o arquivo docker-compose.yaml

docker-compose up -d


# GraphQl reference:

https://graphql.org/


# MySql:

* Para acessar o bash do container do MySql, executar o seguinte comando:

docker exec -it mysql-server bash

* Para logar no MySql:

mysql -u admin -p 

password: admin


# Spring 

Executar a aplicação como "Spring App"

Para executar as querys em graphql, acessar: http://localhost:5000/graphiql

alias
fragment
"!" = Define not null
Para receber "objetos" como parâmetro: inputType (no arquivo .graphqls) / ModelMapper (No java)
