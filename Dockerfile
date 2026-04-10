# Étape 1 : build avec Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Étape 2 : runtime léger
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

# Render fournit PORT en variable d'env
ENV PORT 8080

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT}"]
