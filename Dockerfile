FROM ubuntu:20.04

########################## INSTALANDO JAVA 17 ##########################
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk

########################## INSTALANDO MAVEN 3.9.0 ##########################
ENV MAVEN_VERSION 3.9.0
RUN apt-get update && apt-get install -y curl && \
    mkdir -p /usr/share/maven && \
    curl -fsSL https://dlcdn.apache.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar -xzC /usr/share/maven --strip-components=1 && \
    ln -s /usr/share/maven/bin/mvn /usr/bin/mvn


########################## INSTALANDO POSTGRESQL ##########################
RUN apt-get update && \
    apt-get install -y postgresql postgresql-contrib


########################## CRIAÇÃO DO BANCO DE DADOS ##########################
USER postgres
RUN /etc/init.d/postgresql start && \
    psql --command "CREATE USER lucas WITH PASSWORD 'admin';" && \
    createdb financial_plan && \
    psql --command "grant all privileges on database financial_plan to lucas;"
USER root


########################## CONSTRUINDO PROJETO COM MAVEN ##########################
# Copia o arquivo do projeto para o contêiner
COPY . /app
# Configura o diretório de trabalho
WORKDIR /app
# Constrói o projeto com o Maven
RUN mvn clean package -DfinalName=financial_plan_api
# Expose a porta da aplicação
EXPOSE 8080
# Executa a aplicação
CMD ["java", "-jar", "/app/target/financial_plan_api.jar"]