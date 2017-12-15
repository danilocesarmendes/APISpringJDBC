# APISpringJDBC

api spring utilizando jdbc

# Comandos para iniciar o serviço

No diretório ../APISpringJDBC/api-ldm-teste execute

mvn clean package

cd target/

- o arquivo api-ldm-teste.war pode ser implantado no Container ou iniciado pelo tomcat embarcado com do SpringBoot
 com o seguinte comando.
 
java -jar api-ldm-teste.war

O serviço iniciará na porta 8080

# EndPoint do serviço

localhost:8080/api-ldm-teste/api/estoque/MECA/5
