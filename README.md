# AlgaLog

### Sobre

AlgaLog é uma API desenvolvida para uma sistema de entregas para gerenciar seus pedidos e usuários. Este projeto foi desenvolvido durante o evento da AlgaWorks.

### Tecnologias Utilizadas
Abaixo estão listadas as principais tecnologias utilizadas neste projeto:

- **Java** como linguagem de programação;
- **Spring** Boot como framework para desenvolvimento de aplicações web em Java;
- **Flyway** como ferramenta para controle de versionamento de banco de dados e migração de dados;
- **MySQL** como banco de dados relacional.


### Instalação

Para instalar as dependências necessárias, execute o seguinte comando:

```bash
mvn install
```


### Configuração

Para configurar a aplicação, altere o arquivo .application.properties no diretório *src/main/resources* do projeto e defina as seguintes variáveis de ambiente:

```bash
spring.datasource.url=jdbc:mysql://localhost/algalog
spring.datasource.username=root
```


### Execução

Para iniciar a aplicação, execute a classe *AlgalogApiApplication*