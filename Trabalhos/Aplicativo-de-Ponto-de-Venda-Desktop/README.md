## Aplicativo de Ponto de Venda (PDV) Desktop

#### Nome: Erick Daniel Teixeira Vier - RA: 235908-1

<br>

## Requisitos
- Java 17 ou superior
- Maven 3.6.0 ou superior
- Banco de dados PostgreSQL 15.3 ou superior

## Configuração do Ambiente
1. Instale o Java 17: [Download Java 17](https://www.oracle.com/java/technologies/downloads/#java17)
2. Instale o Maven: [Download Maven](https://maven.apache.org/download.cgi)
3. Crie um banco chamado postgres e um schema chamado pdvdesktop ou modifique o arquivo persistence.xml colocando as informações de seu ambiente

### Compilação e Empacotamento
Execute o seguinte comando na raiz do projeto para compilar o código e gerar o JAR:

```bash
mvn clean package   
ou
mvn clean package -Dmaven.test.skip=true

```
## Execução

```bash
java -jar target/pdv-1.0-SNAPSHOT.jar
```
