FROM maven:3.9.5-eclipse-temurin-21 AS build

WORKDIR /app

COPY producer/pom.xml pom.xml

RUN mvn dependency:go-offline

COPY producer/src ./src

RUN mvn package -DskipTests

FROM amazoncorretto:21-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
