FROM openjdk:17-alpine

ENV SERVER_PORT 8080

ENV DB_URL jdbc:postgresql://postgres:5432/financial_plan
ENV DB_USERNAME lucas
ENV DB_PASSWORD admin

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR da sua aplicação para o contêiner
COPY target/financial_planning-0.0.1-SNAPSHOT.jar .

# Expose a porta da aplicação
EXPOSE $SERVER_PORT
# Executa a aplicação
CMD ["java", "-jar", "/financial_planning-0.0.1-SNAPSHOT.jar"]