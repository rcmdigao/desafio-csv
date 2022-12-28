# Descrição dos Recursos - API RESTful Golden Raspberry Awards 
Desenvolvimento de uma API RESTful para obter o produtor com maior intervalo entre dois prêmios consecutivos, e o que obteve dois prêmios mais rápidos.

# Detalhes dos recursos usados neste projeto:

* Usando Spring Boot e o Tomcat 8 como contêiner do servlet incorporado.
* Um esforço para atender as práticas (HTTP Verbos) identificada no Nível 2 dentro do modelo de maturidade de Leonard Richardson.
* O serviço irá trabalhar com JSON.
* Utilizando o padrão de projeto DTO (Data Transfer Object) - Em resumo superficial esse padrão de projeto utiliza um objeto simples para transferir dados de um local a outro na aplicação.
* Utilizando o Banco de dados H2. O H2 é um banco de dados Java leve e de código aberto. Incorporado neste aplicativo. O banco de dados H2 pode ser configurado para ser executado como um banco de dados na memória, o que significa que os dados não persistirão no disco, assim a base de dados fica rodando na memória sem a necessidade de nenhuma instalação ou serviço de banco de dados externo, mas que também perde todos os dados e alterações realizadas neles ao finalizar a aplicação.
* Carregamento automático dos dados contidos em arquivo CSV, em um processo iniciado junto com a aplicação utilizando Spring Batch.
* Teste unitário executar o JUnit Test.


# Recursos Providos

O projeto fornece e integra testes que aceitará a seguinte solicitação para o método:

HTTP GET em: http://localhost:8080/movies/awardsinterval

### Direcionamento para execução dos testes:

1 - Com o servidor desligado acessar a classe "DesafioFilmesApplicationTests" presente dentro do diretório
"src/test/java/br/com/desafiofilmes"


### URL Disponíveis

1 - Banco de Dados H2: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:~/desafiocsv, Usuário: sa, Senha: )

2 - URL do Endpoint: http://localhost:8080/movies/awardsinterval
