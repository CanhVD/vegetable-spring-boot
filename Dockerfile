#FROM eclipse-temurin:25-jdk
#
## Dành cho Apple Sillicon
## FROM --platform=linux/x86_64 openjdk:17-jdk-alpine3.14
#
#WORKDIR /app
#COPY ./target/vegetable_shop-0.0.1-SNAPSHOT.jar app.jar
#CMD ["java","-jar","app.jar"]


FROM maven:3.9-eclipse-temurin-25 AS builder

WORKDIR /app

COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .

RUN chmod +x mvnw

RUN --mount=type=cache,target=/root/.m2 \
    ./mvnw dependency:go-offline

COPY src src

RUN --mount=type=cache,target=/root/.m2 \
    ./mvnw package -DskipTests

FROM eclipse-temurin:25-jre

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]