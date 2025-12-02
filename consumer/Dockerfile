FROM amazoncorretto:21-alpine AS build

WORKDIR /app

# Copia apenas o que o Maven precisa
COPY mvnw mvnw
COPY .mvn .mvn
COPY consumer/pom.xml pom.xml
COPY consumer/src src

RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline
RUN ./mvnw package -DskipTests

FROM amazoncorretto:21-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
