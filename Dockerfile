#FROM eclipse-temurin:17 AS build
FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .
RUN ./gradlew bootJar --no-daemon

FROM openjdk-17-jdk-slim
EXPOSE 8080
EXPOSE 8081
EXPOSE 8082
COPY --from=build /build/libs/Globify-0.0.1-SNAPSHOT.jar app.jar

LABEL authors="rohitsandadi"

ENTRYPOINT ["java", "-jar", "app.jar"]
# ENTRYPOINT ["top", "-b"]
